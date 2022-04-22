class Student{
	String name;
	 int age;
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
		System.out.println("姓名："+name+"成绩："+age);
	}
}
public class example19{
	public static void main(String[] args){
		Student stud1=new Student();
		Student stud2=new Student();
		stud1.name="张三";
		stud1.age=18;
		stud1.speak();
		stud2.setAge(19);
		stud2.setName("李四");
		stud2.speak();
		
	}
}