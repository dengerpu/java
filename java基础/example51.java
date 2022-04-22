public class example51{
	public static void main(String[] args){
		String s="abcdabcddfffdsasc";
		System.out.println("字符串的长度为"+s.length());
		System.out.println("字符串中第一个字符:"+s.charAt(0));
		System.out.println("字符串中字符c第一次出现的位置"+s.indexOf('c'));
		System.out.println("字符串中字符C最后一次出现的位置"+s.lastIndexOf('c'));
		System.out.println("字符串中子字符串第一次出现的位置"+s.indexOf("ab"));
		System.out.println("字符串中子字符串最后一次出现的位置"+s.lastIndexOf("ab"));
		
	}
}