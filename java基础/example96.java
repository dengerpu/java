import java.util.Map;
import java.util.HashMap;
public class example96{
	public static void main(String[] args){
		Map map=new HashMap();
		map.put("1","jack");		//��Map���������Ԫ��
		map.put("2","rose");
		map.put("3","lucy");
		map.put("1","tom");
		System.out.println(map);
		System.out.println(map.containsKey("1"));		//�жϼ������Ƿ����
		System.out.println(map.containsValue("tom"));   //�ж�ֵ�����Ƿ����
		System.out.println(map.get("1"));			//��ȡ��ֵ��Ӧ�ļ�����
		System.out.println(map.keySet());			//��ȡ�����м�����ĺ�ֵ���󼯺�
		System.out.println(map.values());
		map.replace("1","abc");						//�滻ָ���������ֵ
		System.out.println(map);
		map.remove("1");							//ɾ��ָ���ļ�����
		System.out.println(map);
		
	}
}