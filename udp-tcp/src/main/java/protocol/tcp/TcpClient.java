package protocol.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//1.尝试连接（三次握手）
		Socket socket = new Socket("127.0.0.1", 10010);
		
		//2.写入数据
		OutputStream os = socket.getOutputStream();
		os.write("hello tcpserver,I'm comming,idiot".getBytes());
		//shutdownOutput表明要传输的数据结束，关闭输出流
		socket.shutdownOutput();
		
		//3.接收服务端的反馈
		InputStream is = socket.getInputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = is.read(buffer)) != -1){
			String msg = new String(buffer, 0, len);
			System.out.println("来自服务端的问候：" + msg);
		}
		
		socket.close();
	}
}








