package reflect.bigDemo;

/**
 * 多态：用接口提升代码的扩展性
 * 代码扩展性：当需求变动的时候，代码修改越少，扩展性越强
 *	
 *工厂设计模式：
 *	抽象商品：如接口Singer
 *	实际商品
 */
interface Singer{
	void sing();
}
//要想在配置文件中配置某个歌手或者演员，得先准备一个该歌手的类，这里是放一起的简化写法，实际可以单独放在一个类文件里
public class ZhangXueYou implements Singer {
	public void sing(){
		System.out.println("张学友演唱：一路上有你~~~");
	}
}
//要想在配置文件中配置某个歌手或者演员，得先准备一个该歌手的类，这里是放一起的简化写法，实际可以单独放在一个类文件里
class GuoFuCheng implements Singer{
	public void sing(){
		System.out.println("郭富城演唱：浪漫樱花~~~");
	}
}
