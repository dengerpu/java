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
			System.out.println("�������");
	}
	public int getAge(){
		return age;
	}
	public void speak(){
		System.out.println("������"+name+"�ɼ���"+age);
	}
}
public class example19{
	public static void main(String[] args){
		Student stud1=new Student();
		Student stud2=new Student();
		stud1.name="����";
		stud1.age=18;
		stud1.speak();
		stud2.setAge(19);
		stud2.setName("����");
		stud2.speak();
		
	}
}