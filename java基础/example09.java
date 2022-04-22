class Person{
	public Person(){
		System.out.println("无参的构造方法被调用了");
	}
	public Person(int age){
		this();
		System.out.println("有参的构造方法被调用了");
	}
}
public class example09{
	public static void main(String[] args){
		Person p=new Person(18);
	}
}