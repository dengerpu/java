class Student{
	static String	schoolName;
}
public class example10{
	public static void main(String[] args){
		Student stu1=new Student();
		Student stud2=new Student();
		Student.schoolName="���A��W";
		System.out.println("����"+stu1.schoolName+"�ČW��");
		System.out.println("����"+stud2.schoolName+"�ČW��");
	}
}