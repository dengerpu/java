class Person{
	String name;
	int age;
	public  Person(int a){
		age=a;
	}
	public Person(String n,int a){
		name=n;
		age=a;
	}
	public void speak(){
		System.out.println("�ҽ���"+age+"����");
	}
	public void say(){
		System.out.println("�ҽ�"+name+",����"+age+"����");
	}
}
public class example08{
	public static void main(String[] args){
		Person p1=new Person(18);
		Person p2=new Person("����",32);
		p1.speak();
		p2.say();
	}
}