package protocol.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**io是耗时操作，可能导致线程阻塞，这是此例的缺点，下例中用多线程优化*/
public class UploadServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(10010);
		Socket socket = serverSocket.accept();
		InputStream is = socket.getInputStream();
		
		//读文件，缓冲流
		BufferedInputStream bis = new BufferedInputStream(is);
		File file = new File("C:\\test\\upload");
		if(!file.exists()){
			file.mkdirs();
		}
		/**
		 * 1. 无法保证时间能够唯一确定图片名（ms）
		 * UUID universal unique id(通用唯一标识符)
		 */
//		long times = System.currentTimeMillis();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		File destFile = new File(file, uuid + ".jpg");
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = bis.read(buffer)) != -1){
			bos.write(buffer, 0, len);
			bos.flush();
		}
		
		//给客户端一个反馈
		OutputStream os = socket.getOutputStream();
		os.write("上传成功！".getBytes());
		socket.shutdownOutput();//关闭输出流，告诉对方数据发送完毕
		
		bos.close();
		socket.close();
		
		
	}
}






