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
			System.out.println("输入错误");
		
	}
	public int getAge(){
		return age;
	}
	public void speak(){
		System.out.println("我叫"+name+"今年"+age+"岁了");
	}
}
public class example16{
	public static void main(String[] args){
		Person p=new Person();
		p.setName("张三");
		p.setAge(15);
		p.speak();
	}
}