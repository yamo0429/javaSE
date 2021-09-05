package protocol.summary;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 4. IP对象InetAddress
		1. InetAddress 的实例包含 ` IP 地址`，还可能包含相应的 `主机名`

		2. 方法
			1.  getLocalHost() 返回本地主机
			2.  getByName(String host) 在给定主机名的情况下确定主机的 IP 地址。
			3. getAllByName(String host) 在给定主机名的情况下，根据系统上配置的名称服务返回其 IP 地址所组成的数组。
 *
 */
public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress lh = InetAddress.getLocalHost();
		System.out.println(lh);//spy-PC/10.254.5.36
		System.out.println(lh.getHostName());
		System.out.println(lh.getHostAddress());
		
		InetAddress byName = InetAddress.getByName("www.warrior.cn");
		System.out.println(byName);//  www.warrior.cn/123.57.45.99
		// DNS（Domain Name System，域名系统），因特网上作为域名和IP地址相互映射的一个分布式数据库
		
		// 域名 ： ip  一对多      分布式服务器集群
		InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
		for (InetAddress inetAddress : allByName) {
			System.out.println(inetAddress);
		}
		//www.baidu.com/115.239.210.27
		//www.baidu.com/115.239.211.112
		
	}
}
