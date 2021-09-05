package protocol.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpReceiver2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		//1. 准备一个码头（端口号） 而且要跟发送的集装箱上的端口一致
		DatagramSocket socket = new DatagramSocket(10086);
		//2. 准备一个接收集装箱
		byte[] buf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		//3. 接收集装箱，获取相应的数据
		//用这个集装箱接收发过来的数据
		socket.receive(packet);

		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		System.out.println("发送方socket为："+address + ":" + port);
		
		byte[] data = packet.getData();
		int length = packet.getLength();
		String msg = new String(data, 0, length);
		System.out.println("接收数据长度为："+length+"byte");
		System.out.println("接收数据为："+msg);
		
		/*给发送端反馈一个信息*/
		byte[] sendBuf = "信息已接收，可以退下了！".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, address, port);
		socket.send(sendPacket);
		
		//4. 码头关闭
		socket.close();
		
	}
}
