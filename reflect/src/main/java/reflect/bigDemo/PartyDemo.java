package reflect.bigDemo;

/**
 *  工厂类（读取资源文件、反射获取value、将值返回）+调用（传值）
 */
public class PartyDemo {
	public static void main(String[] args) throws Exception {
		System.out.println("晚会开始！");
		//第一次扩展通用性：接口+多态
		//method
		
		//第二次扩展通用性：工厂类（配置文件+反射）
		Singer singer = PartyFactory.getSinger();
		singer.sing();
		
		Dancer dancer = PartyFactory.getDancer();
		dancer.dance();
		
		Player player = PartyFactory.getPlayer();
		player.show();
		
		System.out.println("难忘今宵！");
	}

	private static void method() {
		/**
		 * 原始形式：类名接收
		 */
//		ZhangXueYou zxy = new ZhangXueYou();
//		zxy.sing();
//		LiuDeHua gfc = new GuoFuCheng();
//		gfc.sing();
		
		/**
		 * 多态形式：接口接收
		 */
		Singer singer1 = new ZhangXueYou();
		singer1.sing();
		Singer singer2 = new GuoFuCheng();
		singer2.sing();
		
		//以下跳舞、表演同上
		//跳舞
		GirlGeneration gg = new GirlGeneration();
		gg.dance();
		//表演小品
		ZhaoBenShan zbs = new ZhaoBenShan();
		zbs.show();
	}
}
