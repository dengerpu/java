import java.util.*;
import java.util.stream.Stream;
public class example117{
	public static void main(String[] args){
		List<String>list=new ArrayList<>();
		list.add("����");
		list.add("����");
		list.add("��С��");
		list.add("����");
		Stream<String>stream=list.stream();
		Stream<String>stream2=stream.filter(i->i.startsWith("��"));//��Streatm���е�Ԫ�طֱ���й��˽�ȡ����
		Stream<String>stream3=stream2.limit(3);
		stream3.forEach(j->System.out.println(j));//�������
		System.out.println("======");
		//ͨ��������ʽ����ʽ��ɾۺϲ���
		list.stream().filter(i->i.startsWith("��"))
					.limit(3)
					.forEach(j->System.out.println(j));
		
	}
}