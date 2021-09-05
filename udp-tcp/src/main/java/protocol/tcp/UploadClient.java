package protocol.tcp;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("127.0.0.1", 10010);
		
		OutputStream os = socket.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("f:\\ioTest\\c\\cx.jpg"));
		
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = bis.read(buffer)) != -1){
			bos.write(buffer, 0, len);
			bos.flush();
		}
		socket.shutdownOutput();
		
		//接收来自服务端的反馈
		InputStream is = socket.getInputStream();
		int readLen = -1;
		byte[] readBuf = new byte[1024];
		while((readLen = is.read(readBuf)) != -1){
			String msg = new String(readBuf, 0, readLen);
			System.out.println("服务端反馈：" + msg);
		}
		bis.close();
		socket.close();//socket关闭后，其is和os两个流对象自动关闭
	}
}
