package protocol.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpReceiver1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		//1. 准备接收地码头,并给它起个名字（端口号）
		DatagramSocket socket = new DatagramSocket(10086);
		//2. 准备接收用的集装箱
		byte[] buf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		//3. 接收集装箱，获取相应的数据
		socket.receive(packet);
		
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		System.out.println("发送方socket为："+address + ":" + port);
		
		byte[] data = packet.getData();
		int length = packet.getLength();
		String msg = new String(data, 0, length);
		System.out.println("接收数据长度为："+length+"byte");
		System.out.println("接收数据为："+msg);
		
		//4. 码头关闭
		socket.close();
		
	}
}
