import java.util.*;
public class example97{
	public static void main(String[] args){
		Map map=new HashMap();
		map.put("1","abc");
		map.put("2","bcd");
		map.put("3","def");
		System.out.println(map);
		Set keySet=map.keySet();        //��ȡ���ļ���
		Iterator it=keySet.iterator();	//�������ļ���
		while(it.hasNext()){
			Object key=it.next();
			Object value=map.get(key);	//��ȡÿ��������Ӧ��ֵ
			System.out.println(key+":"+value);
		}
	}
}