import java.util.ArrayList;
import java.util.Iterator;
public class example85{
	public static void main(String[] args){
		ArrayList list=new ArrayList();
		list.add("adta_1");
		list.add("data_2");	
		list.add("data_3");
		System.out.println(list);
		Iterator it=list.iterator();
		it.forEachRemaining(obj->System.out.println(obj));
		}
}