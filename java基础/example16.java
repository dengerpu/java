class Person{
	String name;
	private int age;
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		if(age>0)
			this.age=age;
		else
			System.out.println("�������");
		
	}
	public int getAge(){
		return age;
	}
	public void speak(){
		System.out.println("�ҽ�"+name+"����"+age+"����");
	}
}
public class example16{
	public static void main(String[] args){
		Person p=new Person();
		p.setName("����");
		p.setAge(15);
		p.speak();
	}
}