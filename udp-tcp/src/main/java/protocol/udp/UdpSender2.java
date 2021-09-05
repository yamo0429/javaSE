package protocol.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSender2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		//1.准备码头:发送的进程由系统自动分配端口，无需手动指定
		DatagramSocket socket = new DatagramSocket();
		
		//2.准备一个集装箱
		byte[] buf = "hello,udp,how are you?".getBytes();
		InetAddress address = InetAddress.getByName("127.0.0.1");
		int port = 10086;
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
		//3.码头发送集装箱
		socket.send(packet);
		
		/*接收来自接收端的信息*/
		byte[] revBuf = new byte[1024];
		DatagramPacket revPacket = new DatagramPacket(revBuf, revBuf.length);
		socket.receive(revPacket);
		byte[] data = revPacket.getData();
		int length = revPacket.getLength();
		String msg = new String(data, 0, length);
		System.out.println("接收端返回信息："+msg);
		
		//4.码头关闭
		socket.close();
	}
}
