import java.util.Comparator;
import java.util.TreeSet;
class MyComparetor implements Comparator{       //定制排序方式
	public int compare(Object obj1,Object obj2){
		String s1=(String)obj1;
		String s2=(String)obj2;
		int temp=s1.length()-s2.length();
		return temp;
	}
}
public class example95{
	public static void main(String[] args){
			TreeSet ts=new TreeSet(new MyComparetor());
			ts.add("Jack");
			ts.add("Helema");
			ts.add("eve");
			System.out.println(ts);
		TreeSet ts2=new TreeSet((obj1,obj2)->{
			String s1=(String)obj1;
			String s2=(String)obj2;
			return s1.length()-s2.length();
		});
		ts2.add("jack");
		ts2.add("helema");
		ts2.add("eve");
		System.out.println(ts2);
	}
}
