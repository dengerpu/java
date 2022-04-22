import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class example114{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer>list=new ArrayList<>();
		Collections.addAll(list,-3,1,2,5,4);
		System.out.println("集合中的元素："+list);
		System.out.println("集合中的最大元素"+Collections.max(list));
		System.out.println("集合中最下元素"+Collections.min(list));
		Collections.replaceAll(list,-3,0);		//将集合中的-3用0替换掉
		System.out.println("替换后的集合:"+list);
		Collections.sort(list);
		System.out.println("集合排序后为:"+list);
		System.out.println("请输入要查找的元素");
		int n=sc.nextInt();
		System.out.println("集合通过二分查找法查找元素"+n+"所在位置为:"+Collections.binarySearch(list,n));
		
	}
}