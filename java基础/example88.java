import java.util.LinkedList;
public class example88{
	public static void main(String[] args){
		LinkedList link=new LinkedList();
		link.add("stu1");                   
		link.add("stu2");
		System.out.println(link);
		link.offer("offer");               //�򼯺�β��׷��Ԫ��
		link.push("push");					//�򼯺�ͷ�����Ԫ��
		System.out.println(link);
		Object object=link.peek();			//��ȡ���ϵ�һ��Ԫ��
		System.out.println(object);
		link.removeFirst();					//�Ƴ������ؼ����еĵ�һ��Ԫ��
		link.pollLast();					//�Ƴ������ؼ��������һ��Ԫ��
		System.out.println(link);
	}
}