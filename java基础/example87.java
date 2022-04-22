import java.util.*;
class Student{
	String id;
	String name;
	public Student(String id,String name){
		this.id=id;
		this.name=name;
	}
	public String toString(){
		return id+":"+name;
	}
}
public class example87{
	public static void main(String[] args){
		HashSet hs=new HashSet();
		Student stud1=new Student("1","Jack");
		Student stud2=new Student("2","Rose");
		Student stud3=new Student("2","Rose");
		hs.add(stud1);
		hs.add(stud2);
		hs.add(stud3);
		System.out.println(hs);
	}
}