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
		if(age<=0)
			System.out.println("�������");
		else
			this.age=age;
		
	}
	public int getAge(){
		return age;
	}
	public void speak(){
		System.out.println("�ҽ�"+name+",����"+age+"����");
	}
}
public class example15{
	public static void main(String[] args){
		Person p=new Person();
		p.setAge(-20);
		p.setName("����");
		p.speak();
	}
}