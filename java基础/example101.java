
public class example101 {
public static void main(String[] args) {
	/*
	 * String replace(char old,char new);
	 * String replace(String old,String new);
	 * String��ȥ���ַ������߿ո�
	 * String trim();
	 * String�����ֵ�˳��Ƚ������ַ���
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
	System.out.println(s5.compareTo(s6));           //�Ƚϵ�������ĸ��С������ĸ��ͬ�Ƚϵڶ���     -1
	String s7="a";
	String s8="aaaa";
	System.out.println(s7.compareTo(s8));    //������Ϊ-3    �Ƚϳ���
}
}
