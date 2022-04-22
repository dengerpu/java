import java.util.*;
import java.util.stream.Stream;
public class example118{
	public static void main(String[] args){
		Integer[] array={9,8,3,5,2};
		List<Integer>list=Arrays.asList(array);
		Stream<Integer>stream=list.stream();  //1.使用集合对象的stream静态方法创建stream流对象
		stream.forEach(i->System.out.print(i+" "));
		System.out.println();
		Stream<Integer>stream2=Stream.of(array);
		stream.forEach(i->System.out.print(i+" "));//2.使用Stream接口的of方法创建Stream流对象
		System.out.println();
		Stream<Integer>stream3=Arrays.stream(array); //3.使用Arrays数组工具类的stream方法创建stream流对象
		stream3.forEach(i->System.out.print	(i+" "));
		
	}
}