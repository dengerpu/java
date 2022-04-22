import java.util.LinkedList;
import java.util.Iterator;
public class example81{
	public static void main(String[] args){
		LinkedList link=new LinkedList();
		link.add("stu1");
		link.add("stu2");
		System.out.println(link);
		link.offer("offer");                    //向集合尾部追加元素
		link.push("push");                      //向集合头部添加元素
		System.out.println(link);
		Object object=link.peek();    			//获取集合第一个元素
		System.out.println(object);				
		link.removeFirst();                      //删除集合第一个元素
		link.pollLast();                         //删除集合最后一个元素
		System.out.println(link);
		Iterator iterator=link.iterator();
		while(iterator.hasNext()){
			Object obj=iterator.next();
			System.out.println(obj);
		}
	}
}