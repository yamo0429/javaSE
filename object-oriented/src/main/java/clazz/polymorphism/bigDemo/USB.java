package clazz.polymorphism.bigDemo;

/**
 * 笔记本厂商为了以后方便扩展功能，定义了USB接口规范
 *（留下一个USB接口）
 */
public interface USB {
	
	void open(String name);
	
	void close(String name);
}
