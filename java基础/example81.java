import java.util.LinkedList;
import java.util.Iterator;
public class example81{
	public static void main(String[] args){
		LinkedList link=new LinkedList();
		link.add("stu1");
		link.add("stu2");
		System.out.println(link);
		link.offer("offer");                    //�򼯺�β��׷��Ԫ��
		link.push("push");                      //�򼯺�ͷ�����Ԫ��
		System.out.println(link);
		Object object=link.peek();    			//��ȡ���ϵ�һ��Ԫ��
		System.out.println(object);				
		link.removeFirst();                      //ɾ�����ϵ�һ��Ԫ��
		link.pollLast();                         //ɾ���������һ��Ԫ��
		System.out.println(link);
		Iterator iterator=link.iterator();
		while(iterator.hasNext()){
			Object obj=iterator.next();
			System.out.println(obj);
		}
	}
}