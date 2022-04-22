public class example53{
	public static void main(String[] args){
		String s="	http:// lo cal : 8080   ";
		System.out.println("去除字符串两空格后的结果"+s.trim());
		System.out.println("去除字符串中所有空格后的结果"+s.replace(" ",""));
	}
}