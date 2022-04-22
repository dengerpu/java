class Student{
	static String	schoolName;
}
public class example10{
	public static void main(String[] args){
		Student stu1=new Student();
		Student stud2=new Student();
		Student.schoolName="清華大學";
		System.out.println("我是"+stu1.schoolName+"的學生");
		System.out.println("我是"+stud2.schoolName+"的學生");
	}
}