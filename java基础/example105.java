public class example105{
	public static void main(String[] args){
		/**
		*public StringBuffer append(String str):可以把任意类型的数据添加到字符串的缓冲区里
		*public StringBuffer insert(int offset,String str): 在指定位置把任意类型的数据插入到字符串缓冲区里，并返回字符串缓冲区本身
		*/
		StringBuffer sb=new StringBuffer();
		StringBuffer sb2=sb.append("heima");
		StringBuffer sb3=sb.append(100);
		
		
		System.out.println(sb.toString());
		System.out.println(sb2.toString());
		System.out.println(sb3.toString());
		
		sb.insert(0,"1234");
		System.out.println(sb.toString());
	}
	
}