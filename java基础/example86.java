import java.util.HashSet;
public class example86{
	public static void main(String[] args){
		HashSet set=new HashSet();                       //���洢��Ԫ���ǲ����ظ��ģ�����Ԫ�ض��������
		set.add("jack");
		set.add("eve");
		set.add("rose");
		set.add("rose");
		set.forEach(o->System.out.println(o));
	}
	}