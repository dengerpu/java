import java.util.ArrayList;
import java.util.Collections;
public class example113{
	public static void main(String[] args){
		ArrayList<String>list=new ArrayList<String>();
		Collections.addAll(list,"c","z","b","k");		//���Ԫ��
		System.out.println("����ǰ:"+list);				
		Collections.reverse(list);						//��ת����
		System.out.println("��ת��:"+list);
		Collections.sort(list);							//����Ȼ��������
		System.out.println("����Ȼ�����:"+list);
		Collections.shuffle(list);
		System.out.println("�����˳�������"+list);
		Collections.swap(list,0,list.size()-1);			//������βԪ�ؽ���
		System.out.println("������βԪ�ؽ�����:"+list);
		
	}
}