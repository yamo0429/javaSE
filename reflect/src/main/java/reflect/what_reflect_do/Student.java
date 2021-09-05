package reflect.what_reflect_do;

/**
 * Student类
 * 		1. private构造（有参）    public（空参，有参）
 * 		2. 属性： private   public  
 *		3. 方法：private  public  static  non-static
 */
public class Student {
	
	private String name;
	private int age;
	public int id;
	
	public static void main(String[] args) {
		System.out.println("0:" + args[0] + ";1:" + args[1]);
	}
	
	public Student() {
		super();
	}
	/*private  Student() {  //如果无参构造是私有的，也可通过clazz.getDeclaredConstructor()反射得到构造器对象
		super();
	}*/
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private Student(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	public void show(String msg){
		System.out.println(msg + " is show");
	}
	private void speak(String msg){
		System.out.println(msg + " is speak");
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	
	
}
//@Override
//public int hashCode() {
//	final int prime = 31;
//	int result = 1;
//	result = prime * result + ((name == null) ? 0 : name.hashCode());
//	return result;
//}

//@Override
//public boolean equals(Object obj) {
//	if (this == obj)
//		return true;
//	if (obj == null)
//		return false;
//	/**
//	 * getClass  =  this.getClass 本类类型 Student
//	 * obj.getClass = 根据实际参数类型，返回这个对象类型
//	 * 
//	 * 相当于   obj instanceof Student
//	 */
//	if (getClass() != obj.getClass())
//		return false;
//	Student other = (Student) obj;
//	if (name == null) {
//		if (other.name != null)
//			return false;
//	} else if (!name.equals(other.name))
//		return false;
//	return true;
//}
