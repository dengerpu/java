class Student{
	String name;
	int age;
	public  Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void show(){
		System.out.println("姓名:"+name);
		System.out.println("年龄:"+age);
	}
}
class Undergraduate extends Student{
	String degree;
	public  Undergraduate(String name,int age,String degree){
		super(name,age);
		this.degree=degree;
	}
	public void show(){
		System.out.println("姓名:"+name+"年龄:"+age+"学位:"+degree);
	}
}
public class example49{
	public static void main(String[] args)
	{
		Student student=new Student("张三",16);
		student.show();
		Undergraduate degree=new Undergraduate("李四",20,"博士");
		
		degree.show();
	}
}