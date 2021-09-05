package protocol.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**多线程优化upload案例，服务器永不关停*/
public class UploadServerByThread {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(10010);
		while(true){
			Socket socket = serverSocket.accept();
			//不能让IO阻塞线程，io是耗时操作
			new Thread(new UploadTask(socket)).start();
		}
//		socket.close();//服务器永远处于读取状态
		
	}
}

class UploadTask implements Runnable{
	Socket socket;
	public UploadTask(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			File file = new File("f:\\ioTest\\upload");
			if(!file.exists()){
				file.mkdirs();
			}
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			File destFile = new File(file, uuid + ".jpg");
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
			
			byte[] buffer = new byte[1024];
			int len = -1;
			/**
			 * IO读写：典型的耗时操作
			 */
			while((len = bis.read(buffer)) != -1){
				bos.write(buffer, 0, len);
				bos.flush();
			}
			OutputStream os = socket.getOutputStream();
			os.write("上传成功！".getBytes());
			socket.shutdownOutput();
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}






