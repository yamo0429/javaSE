package protocol.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(10010);
		//1.accept开启等待外界连接的状态，一旦连接成功，返回该连接对象
		Socket socket = serverSocket.accept();
		
		//2.获取客户端发送的信息
		InputStream is = socket.getInputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		//read 也是阻塞方法，要读到对方信息的末尾才能结束，因此客户端要给个末尾提示：shutdownOutput
		while((len = is.read(buffer)) != -1){
			String msg = new String(buffer, 0, len);
			System.out.println(msg);
		}
		//3. 给客户端反馈信息
		OutputStream os = socket.getOutputStream();
		os.write("已收到，how old are you ?".getBytes());
		//同样，反馈的数据是否到了结尾，也要手动提示对方。无论客户端还是服务端，只要发送操作都要shutdownOutput
		socket.shutdownOutput();
		
		//4. 关闭通道
		socket.close();
		serverSocket.close();
		
	}
}
