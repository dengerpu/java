public class example104{
	public static void main(String[] args){
		/*
		* public StringBuffer();  无参构造方法v
		* public StringBuffer(int capacity): 指定容量的字符串缓冲区对象
		* public StringBuffer（String str）:指定字符串内容的字符串缓冲区对象
		* StringBuffer的方法：
		* public int capacity():返回当前容量           理论值
		* public int length():返回长度                 实际值
		*/
		StringBuffer s=new StringBuffer();
		System.out.println(s.capacity());
		System.out.println(s.length());
		
		
		StringBuffer s1=new StringBuffer(10);
		System.out.println(s1.capacity());
		System.out.println(s1.length());
		
		
		StringBuffer s2=new StringBuffer("abcdef");
		System.out.println(s2.capacity());
		System.out.println(s2.length());
	}
	
}