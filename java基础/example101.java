
public class example101 {
public static void main(String[] args) {
	/*
	 * String replace(char old,char new);
	 * String replace(String old,String new);
	 * String的去除字符串两边空格
	 * String trim();
	 * String按照字典顺序比较两个字符串
	 * int compareTo(String str)
	 * int compareToIgnoreCase(String str)
	 * */
	String s="abcdefg";
	String s1=s.replace('b','a');
	System.out.println(s1);
	String s2=s.replace("aa","ab");
	System.out.println(s2);
	String s3="   ab  cd   ";
	System.out.println(s3);
	String s4=s3.trim();
	System.out.println(s4);
	String s5="abc";
	String s6="bcd";
	System.out.println(s5.compareTo(s6));           //比较的是首字母大小，首字母相同比较第二个     -1
	String s7="a";
	String s8="aaaa";
	System.out.println(s7.compareTo(s8));    //输出结果为-3    比较长度
}
}
