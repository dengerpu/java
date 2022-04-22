class Person{
	private String name;
	private int age;
	public String getName(){
		return name;
	}
	public void setName(String name ){
		this.name=name;

	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		if(age<=0){
			System.out.println("你输入的年龄不正确");
		}else{
			this.age=age;
		}
	}
	public void speak(){
		System.out.println("我叫"+name+",今年"+age+"了");
	}
}
public class example04{
	public static void main(String[] args){
		Person p=new Person();
		p.setName("张三");
		p.setAge(-18);
		p.speak();
	}
}