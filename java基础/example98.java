import java.util.*;
import java.util.Map;
import java.util.HashMap;
public class example98{
	public static void main(String[] args){
		Map map=new HashMap();
		map.put("1","abc");
		map.put("2","bcd");
		map.put("3","def");
		System.out.println(map);
		Set entrySet=map.entrySet();
		Iterator it=entrySet.iterator();		//��ȡ�����м�ֵ��ӳ��
		while(it.hasNext()){
			map.Entry entry=(Map.Entry)(it.next());
			Object key=entry.getKey();
			Object value=entry.getValue();
			System.out.println(key+":"+value);
		}
	}
}