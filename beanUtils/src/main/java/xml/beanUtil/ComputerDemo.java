package xml.beanUtil;

import java.io.FileInputStream;
import java.util.Properties;

public class ComputerDemo {
	static Properties p = new Properties();
	static{
		try {
			p.load(new FileInputStream("usb.properties"));
		} catch (Exception e) {
		}
	}
	public static void main(String[] args) throws Exception {
		//只要调用者告诉我们 USB设备在哪里，框架可以直接创建（反射）
		String mouseName = p.getProperty("mouse");
		Class<?> mouseCls = Class.forName(mouseName);
		USB mUsb = (USB) mouseCls.newInstance();
		
		String keyboardName = p.getProperty("keyboard");
		Class<?> keyboardCls = Class.forName(keyboardName);
		USB kUsb = (USB) keyboardCls.newInstance();
		
		Computer computer = new Computer();
		computer.useUSB(mUsb);
		computer.useUSB(kUsb);
	}

	private static void method() {
		//买一个电脑
		Computer c = new Computer();
		Mouse m = new Mouse();
//		c.useMouse(m);
		c.useUSB(m);
		
		c.useUSB(new NbMouse());
		
		KeyBoard k = new KeyBoard();
		c.useUSB(k);
	}
}

interface USB{
	void open();
}

class Computer{
	
	void show(){
		System.out.println("笔记本电脑正常运行。。。");
	}
	void useUSB(USB usb){
		usb.open();
	}
//	void  useMouse(Mouse m){
//		m.open();
//	}
//	void useKeyBoard(KeyBoard k){
//		k.open();
//	}
}

class Mouse implements USB{
	
	public void open(){
		System.out.println("鼠标正常打开！！");
	}
}

class NbMouse implements USB{
	@Override
	public void open(){
		System.out.println("new balance 鼠标正常打开！！");
	}
	public void bling(){
		System.out.println("nb mouse is bling bling...");
	}
}

class KeyBoard implements USB{
	
	public void open(){
		System.out.println("键盘打开了！");
	}
}
