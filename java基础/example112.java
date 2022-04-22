import java.util.Map;
import java.util.TreeMap;
class CustomComparator implements Comparator{
	public int compare(Object obj1,Object obj2){
		String key1=(String)obj1;
		String key2=(String)obj2;
		return key2.compareTo(key1);
	}
}
public class example112{
	public static void main(String[] args){
		Map map=new TreeMap(new CustomComparator());
		map.put("2","rose");
		map.put("1","jack");
		map.put("3","lucy");
		System.out.println(map);
	}
}