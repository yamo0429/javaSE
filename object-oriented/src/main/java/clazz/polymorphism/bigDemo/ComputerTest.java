package clazz.polymorphism.bigDemo;

import org.junit.Test;

/**
 * 规范在java中的含义：接口
 * 多态：极大的提升了代码的扩展性
 * 		笔记本电脑不容易过时
 */
public class ComputerTest {

	@Test
	public void computerTest() {
		//买一个笔记本电脑
		Computer c = new Computer();
		c.name = "mansuper";
		//测试电脑基本功能
		c.powerOn();
		c.powerOff();
		
		//发现电脑有个USB接口
		
		//买一个鼠标
		Mouse m = new Mouse();   //也可以在此处直接使用父类USB接收，然后直接调用接口方法（不用再调用useUSB方法），就会调用子类重写的方法了！如下
		//接入电脑
		c.useUSB(m);

		//或者，直接用父类接收
		//买一个鼠标
		/*USB usb = new Mouse();
		usb.close("zhangsan");
		usb.open("zhangsan");*/

		
		//又买了键盘
		KeyBoard k = new KeyBoard();
		c.useUSB(k);
		
		//又入手了牛逼鼠标
		NbMouse nbMouse = new NbMouse();
		c.useUSB(nbMouse);
//		nbMouse.bling();//手动调用
		
	}
}




