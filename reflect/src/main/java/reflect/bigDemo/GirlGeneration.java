package reflect.bigDemo;

interface Dancer{
	void dance();
}
public class GirlGeneration implements Dancer{
	
	public void dance(){
		System.out.println("少女时代：GEE  GEE GEE.....");
	}
}
class AKB48 implements Dancer{
	
	public void dance(){
		System.out.println("ABK：卖萌广场舞 ^-^ ");
	}
}
