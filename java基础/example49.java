class Student{
	String name;
	int age;
	public  Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void show(){
		System.out.println("����:"+name);
		System.out.println("����:"+age);
	}
}
class Undergraduate extends Student{
	String degree;
	public  Undergraduate(String name,int age,String degree){
		super(name,age);
		this.degree=degree;
	}
	public void show(){
		System.out.println("����:"+name+"����:"+age+"ѧλ:"+degree);
	}
}
public class example49{
	public static void main(String[] args)
	{
		Student student=new Student("����",16);
		student.show();
		Undergraduate degree=new Undergraduate("����",20,"��ʿ");
		
		degree.show();
	}
}