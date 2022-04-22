import java.util.*;
class Student{
	private String id;
	private String name;
	public Student(String id,String name){
		this.id=id;
		this.name=name;
	}
	//重写toString（）方法
	public String toString(){
		return id+":"+name;
	}
	//重写hashCode()方法
	public int hashCode(){
		return id.hashCode();
	}
	public boolean equals(object obj){
		if(this==obj){
			return ture;
		}
		if(!(obj instanceof Student)){
			return flase;
		}
		Student stu=(Student)obj;
		boolean b=this.id.equals(stu.id);
		return b;
		
	}
}
public class example92{
	public static void main(String[] args){
		HashSet hs=new HashSet();
		Student stu1=new Student("1","Jack");
		Student stu2=new Student("2","rose");
		Student stu3=new Student("2","rose");
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		System.out.println(hs);
	}
}