package map;
import map.OuterInter.InnerInte ;

import java.util.Hashtable;

/**
 * 1. 内部接口
		1. 定义在接口内部的接口
		2. 实现类,可以直接实现外部接口,无需同时实现内部接口
		3. 实现类,可以直接实现内部接口(外接口名.内接口) 或者 导包
		4. 实现类也可同时实现外部和内部接口
 *
 */
public interface OuterInter {

	int I = 3;
	void outerMethod();
	//默认用static修饰
	interface InnerInte{
		void innerMethod();
	}
}
class A implements OuterInter{

	@Override
	public void outerMethod() {
		// TODO Auto-generated method stub
	}
}
class B implements OuterInter.InnerInte {  //导包实现


	@Override
	public void innerMethod() {

	}
}
class C implements OuterInter,OuterInter.InnerInte{

	@Override
	public void innerMethod() {
		// TODO Auto-generated method stub
		Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
	}

	@Override
	public void outerMethod() {
		// TODO Auto-generated method stub
		
	}
	
}



