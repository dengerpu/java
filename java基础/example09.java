class Person{
	public Person(){
		System.out.println("�޲εĹ��췽����������");
	}
	public Person(int age){
		this();
		System.out.println("�вεĹ��췽����������");
	}
}
public class example09{
	public static void main(String[] args){
		Person p=new Person(18);
	}
}