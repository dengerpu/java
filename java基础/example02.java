import java.util.*;
class Student {
	String name;
	int age;
	public Student() {
	}
	public Student(String n, int a) {
		name = n;
		age = a;
	}
	void show() {
		System.out.println("Student��ʵ������name:"+name+",age:"+age);
	}
}
class Undergraduate extends Student {
	String degree;
	public Undergraduate(String n, int a, String d) {
		name = n;
		age = a;
		degree = d;
	}
	void show() {
		System.out.println("Undergraduate��ʵ������name:"+name+",degree:"+degree+",age:"+age);
	}
}
public class example02{
	public static void main(String[] args) {
		Student student = new Student("�", 19);
		Undergraduate undergraduate = new Undergraduate("����", 23, "˶ʿ");
		student.show();
		undergraduate.show();
	}
}