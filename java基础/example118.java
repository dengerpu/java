import java.util.*;
import java.util.stream.Stream;
public class example118{
	public static void main(String[] args){
		Integer[] array={9,8,3,5,2};
		List<Integer>list=Arrays.asList(array);
		Stream<Integer>stream=list.stream();  //1.ʹ�ü��϶����stream��̬��������stream������
		stream.forEach(i->System.out.print(i+" "));
		System.out.println();
		Stream<Integer>stream2=Stream.of(array);
		stream.forEach(i->System.out.print(i+" "));//2.ʹ��Stream�ӿڵ�of��������Stream������
		System.out.println();
		Stream<Integer>stream3=Arrays.stream(array); //3.ʹ��Arrays���鹤�����stream��������stream������
		stream3.forEach(i->System.out.print	(i+" "));
		
	}
}