class Student{
	String name;
	int age;
	public Student(String name,int age)
	{	
	this.name=name;
	this.age=age;
	}
	void show()
	{
		System.out.println("姓名:"+name+"  年龄"+age);
	}
}
class Undergradate extends Student{
	String degree;
	public Undergradate(String name,int age,String degree){
		super(name,age);
		this.degree=degree;
	}
	void show(){
		System.out.println("姓名:"+name+"  年龄"+age+"  学位"+degree);
	}
}
public class example441{
	public static void main(String[] args){
		Student stud1=new Student("小王",18);
		Undergradate stud2=new Undergradate("小王",18,"博士");
		stud1.show();
		stud2.show();
		
	}
}