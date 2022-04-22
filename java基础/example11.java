class Person{
	static{
		System.out.println("执行了Person类中的静态马快");
	}
}
public class example11{
	static{
		System.out.println("执行了测试类中的静态代码块");
	}
	public static void main(String[] args){
		Person p1=new Person();
		Person p2=new Person();
		
	}
}