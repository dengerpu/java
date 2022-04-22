import java.util.*;
public class example111{
	public static void main(String[] args){
		Map map1=new HashMap();
		map1.put("1","tom");
		map1.put("3","jack");
		map1.put("2","lucy");
		map1.forEach((key,value)->System.out.println(key+":"+value));
		Map map2=new LinkedHashMap();
		map2.put("1","tom");
		map2.put("3","jack");
		map2.put("2","lucy");
		map2.forEach((key,value)->System.out.println(key+":"+value));
	}
}