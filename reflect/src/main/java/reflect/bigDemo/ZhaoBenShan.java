package reflect.bigDemo;

interface Player{
	void show();
}
public class ZhaoBenShan implements Player{
	
	public void show(){
		System.out.println("赵本山表演小品：拐卖！");
	}
}
class LiuQian implements Player{
	
	public void show(){
		System.out.println("刘谦表演魔术：大便！");
	}
}
