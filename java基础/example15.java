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
			System.out.println("年龄错误");
		else
			this.age=age;
		
	}
	public int getAge(){
		return age;
	}
	public void speak(){
		System.out.println("我叫"+name+",今年"+age+"岁了");
	}
}
public class example15{
	public static void main(String[] args){
		Person p=new Person();
		p.setAge(-20);
		p.setName("张三");
		p.speak();
	}
}