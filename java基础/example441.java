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
		System.out.println("����:"+name+"  ����"+age);
	}
}
class Undergradate extends Student{
	String degree;
	public Undergradate(String name,int age,String degree){
		super(name,age);
		this.degree=degree;
	}
	void show(){
		System.out.println("����:"+name+"  ����"+age+"  ѧλ"+degree);
	}
}
public class example441{
	public static void main(String[] args){
		Student stud1=new Student("С��",18);
		Undergradate stud2=new Undergradate("С��",18,"��ʿ");
		stud1.show();
		stud2.show();
		
	}
}