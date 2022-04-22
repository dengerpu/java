import java.util.Map;
import java.util.HashMap;
public class example96{
	public static void main(String[] args){
		Map map=new HashMap();
		map.put("1","jack");		//像Map集合中添加元素
		map.put("2","rose");
		map.put("3","lucy");
		map.put("1","tom");
		System.out.println(map);
		System.out.println(map.containsKey("1"));		//判断键对象是否存在
		System.out.println(map.containsValue("tom"));   //判断值对象是否存在
		System.out.println(map.get("1"));			//获取键值对应的键对象
		System.out.println(map.keySet());			//获取集合中键对象的和值对象集合
		System.out.println(map.values());
		map.replace("1","abc");						//替换指定键对象的值
		System.out.println(map);
		map.remove("1");							//删除指定的键对象
		System.out.println(map);
		
	}
}