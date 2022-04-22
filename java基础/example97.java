import java.util.*;
public class example97{
	public static void main(String[] args){
		Map map=new HashMap();
		map.put("1","abc");
		map.put("2","bcd");
		map.put("3","def");
		System.out.println(map);
		Set keySet=map.keySet();        //获取键的集合
		Iterator it=keySet.iterator();	//迭代器的集合
		while(it.hasNext()){
			Object key=it.next();
			Object value=map.get(key);	//获取每个键所对应的值
			System.out.println(key+":"+value);
		}
	}
}