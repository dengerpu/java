class Person{
	int age;
	public Person(int a){
		age=a;
	}
	public void speak(){
		System.out.println("我今年"+age+"岁了");
	}
}
public class example07{
	public static void main(String[] args){
		Person p=new Person(18);
		p.speak();
	}
}