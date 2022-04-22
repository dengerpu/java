import java.util.*;
import java.util.stream.Stream;
public class example117{
	public static void main(String[] args){
		List<String>list=new ArrayList<>();
		list.add("张三");
		list.add("李四");
		list.add("张小明");
		list.add("张阳");
		Stream<String>stream=list.stream();
		Stream<String>stream2=stream.filter(i->i.startsWith("张"));//对Streatm流中的元素分别进行过滤截取操作
		Stream<String>stream3=stream2.limit(3);
		stream3.forEach(j->System.out.println(j));//遍历输出
		System.out.println("======");
		//通过链表表达式的形式完成聚合操作
		list.stream().filter(i->i.startsWith("张"))
					.limit(3)
					.forEach(j->System.out.println(j));
		
	}
}