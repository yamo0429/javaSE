package clazz.polymorphism.bigDemo;

public class Computer {
	//笔记本的拥有者名字
	String name;
	public void powerOn(){
		System.out.println("笔记本电脑开启了");
	}
	public void powerOff(){
		System.out.println("笔记本电脑关机了");
	}
	
	/**
	 * 笔记本厂商想要扩展笔记本的功能，但是暂时想不通会扩展什么，那么就留下一个规范USB
	 */
	//当符合usb规范的设备接入时，笔记本电脑自动调用
	public void useUSB(USB usb){
		usb.open(name);
		usb.close(name);
		/**
		 * 笔记本厂商发现牛逼鼠标成为现象级，决定对其兼容
		 * 插入就发光
		 */
		if(usb instanceof NbMouse){
			NbMouse nm = (NbMouse) usb;
			nm.bling();
		}
	}
}







