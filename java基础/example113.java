import java.util.ArrayList;
import java.util.Collections;
public class example113{
	public static void main(String[] args){
		ArrayList<String>list=new ArrayList<String>();
		Collections.addAll(list,"c","z","b","k");		//添加元素
		System.out.println("排序前:"+list);				
		Collections.reverse(list);						//反转集合
		System.out.println("反转后:"+list);
		Collections.sort(list);							//按自然排序排列
		System.out.println("按自然排序后:"+list);
		Collections.shuffle(list);
		System.out.println("按随机顺序排序后"+list);
		Collections.swap(list,0,list.size()-1);			//集合首尾元素交换
		System.out.println("集合首尾元素交换后:"+list);
		
	}
}