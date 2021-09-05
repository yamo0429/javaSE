package protocol.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 问题：发送和接收代码不能够相互干扰？？？
 * 解决： 多线程！！！
 * 
 * 注意：java.net.BindException: Address already in use: Cannot bind
 * 		1. 端口只能被一个进程绑定，测试之前确认之前的程序关闭
 */
public class UdpChatDemo {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//这些信息(来自于用户登录信息)
		InetAddress address = InetAddress.getByName("127.0.0.1");
		int port = 10086;
		
		//1. 创建码头（port） 接收和发送用同一个socket
		DatagramSocket socket = new DatagramSocket(port);
		
		//2. 发送
		SendTask sendTask = new SendTask(socket,address,port);
		new Thread(sendTask).start();
		
		//3. 接收
		ReceiveTask receiveTask = new ReceiveTask(socket);
		new Thread(receiveTask).start();
		
	}
}

class SendTask implements Runnable{
	DatagramSocket socket;
	InetAddress address;
	int port;
	public SendTask(DatagramSocket socket, InetAddress address, int port) {
		this.socket = socket;
		this.address = address;
		this.port = port;
	}

	@SuppressWarnings("resource")
	@Override
	public void run() {
		/**
		 * 1. 文本数据：总有读到末尾的时候，循环就停止了
		 * 2. 控制台：只要用户不停止输入，就一直循环
		 */
//		BufferedReader br = new BufferedReader(null);
//		String line = null;
//		while((line = br.readLine()) != null){
//			
//		}
		Scanner sc = new Scanner(System.in);
		String line = null;
		while((line = sc.nextLine()) != null){
			//TODO： 如何停止聊天  （实际应用：直接关闭窗口）
			/**
			 * 1. 控制台输入的null其实是字符串“null” ，不是null值
			 * 2. 定义一个协议（规则）：exit
			 */
			if("exit".equalsIgnoreCase(line)){
				System.out.println("你不想跟他说话，直接抛出一个exit！");
				byte[] buf = line.getBytes();
				DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
				
				try {
					//长连接，不能关
					socket.send(packet);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			// 1.码头
			//2.准备一个发送的集装箱（地址）
			byte[] buf = line.getBytes();
			DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
			
			try {
				//长连接，不能关
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class ReceiveTask implements Runnable{
	DatagramSocket socket;
	public ReceiveTask(DatagramSocket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// 码头
		//接收的集装箱
		/**
		 * 循环接收
		 */
		while(true){
			byte[] buf = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			
			try {
				socket.receive(packet);
				InetAddress address = packet.getAddress();
				
				byte[] data = packet.getData();
				int length = packet.getLength();
				String msg = new String(data, 0, length);
				
				System.out.println(address + ":" + msg);
				if("exit".equalsIgnoreCase(msg)){
					System.out.println("对方上厕所了，跟你拜拜！");
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}











