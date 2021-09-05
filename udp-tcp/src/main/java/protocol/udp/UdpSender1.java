package protocol.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSender1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		//1.准备发送地码头。发送的进程由系统自动分配端口，无需手动指定。下面的端口与接收地端口对接
		DatagramSocket socket = new DatagramSocket();
		
		//2.准备发送用的集装箱，并在集装箱上指定目的地码头（端口号）
		byte[] buf = "hello,udp,how are you?".getBytes();
		InetAddress address = InetAddress.getByName("127.0.0.1");
		int port = 10086;
		
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
		//3.码头发送集装箱
		socket.send(packet);
		//4.码头关闭
		socket.close();
	}
}
