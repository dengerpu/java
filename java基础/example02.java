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
		System.out.println("Student的实例对象：name:"+name+",age:"+age);
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
		System.out.println("Undergraduate的实例对象：name:"+name+",degree:"+degree+",age:"+age);
	}
}
public class example02{
	public static void main(String[] args) {
		Student student = new Student("李华", 19);
		Undergraduate undergraduate = new Undergraduate("李明", 23, "硕士");
		student.show();
		undergraduate.show();
	}
}