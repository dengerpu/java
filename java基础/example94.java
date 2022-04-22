import java.util.TreeSet;
class Teacher implements Comparable{
	String name;
	int age;
	public Teacher(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return name+":"+age;
	}
	public int compareTo(Object obj){
		Teacher s=(Teacher)obj;
		if(this.age-s.age>0)           //����ȽϷ�ʽ���ȱȽ�����age,�ٱȽ�����name;
			return 1;
		if(this.age-s.age==0)
			return this.name.compareTo(s.name);  //���������ͬ�ͱȽ�����
		return -1;
	}
}
public class example94{
	public static void main(String[] args){
		TreeSet ts=new TreeSet();
		ts.add(new Teacher("jack",19));
		ts.add(new Teacher("rose",18));
		ts.add(new Teacher("tom",19));
		ts.add(new Teacher("rose",18));
		System.out.println(ts);
	}
}