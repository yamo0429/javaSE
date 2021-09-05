package proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SuperDemo {
	
	public static void main(String[] args) {
		//原始调用方式
		/*Hebe hebe = new Hebe();
		hebe.sing(100);
		hebe.liveShow(1000);
		hebe.sleep();*/
		
		//动态代理方式
		final Hebe hebe = new Hebe(); //局部变量 被匿名内部类调用，必须用final修饰（jdk8 已经修复）
		
		ClassLoader loader = hebe.getClass().getClassLoader();
		Class<?>[] interfaces = hebe.getClass().getInterfaces();
		SuperStar proxy = (SuperStar)Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				/**
				 * 需求： 
				 *   1. 唱歌、参加真人秀，价格要商量
				 *   2. 睡觉没得商量
				 */
				String name = method.getName();
				if("sing".equals(name)){
					int money = (int) args[0];
					if(money < 100000){
						System.out.println("滚蛋，钱不够，好好挣钱吧！");
					}else{
						System.out.println("中介抽成" + money * 0.3);
						//args[0] = money * 0.7;
						//调用原主的原有方法
						return method.invoke(hebe, money); 
					}
				}else if("liveShow".equals(name)){
					int money = (int) args[0];
					if(money < 1000000){
						System.out.println("滚蛋，钱不够，好好挣钱吧！");
					}else{
						System.out.println("中介抽成" + money * 0.3);
						//args[0] = money * 0.7;
						//调用原主的原有方法
						return method.invoke(hebe, args);
					}
				}else{
					System.out.println("滚犊子，睡觉跟你没关系！");
				}
				return null;
			}
		});
		
		proxy.sing(100000);
		proxy.liveShow(100);
		proxy.sleep();
	}
}
