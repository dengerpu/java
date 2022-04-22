import java.util.ArrayList;
import java.util.Iterator;
public class example84{
	public static void main(String[] args){
		ArrayList list=new ArrayList();
		list.add("Jack");
		list.add("Annie");
		list.add("Rose");
		list.add("Tom");
		Iterator it=list.iterator();
		while(it.hasNext()){
			Object obj=it.next();
			/*if("Annie".equals(obj)){
				list.remove(obj);
				break;*/
				if("Annie".equals(obj)){
					it.remove();
				}
			}
			System.out.println(list);
		}

	}
