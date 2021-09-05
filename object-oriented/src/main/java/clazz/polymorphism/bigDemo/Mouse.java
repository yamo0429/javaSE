package clazz.polymorphism.bigDemo;

/**
 * 第三方厂商发现笔记本电脑需要一个外接设备，更好的移动指针
 * 开发了鼠标（必须遵循笔记本厂商留下的USB接口规范）
 *
 */
public class Mouse implements USB{

	@Override
	public void open(String name) {
		System.out.println(name + "  is opening mouse...");
	}

	@Override
	public void close(String name) {
		System.out.println(name + " is closing mouse...");
	}

}
