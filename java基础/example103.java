public class example103{    //求大字符串中小字符串的个数 
public static void main(String[] args){
	String s1="abcdabcdfggabdfjhab";
	String s2="ab";
	int count=0,index=0;
	while((index=s1.indexOf(s2))!=-1)
	{
		count++;
		s1=s1.substring(index+s2.length());
	}
	System.out.println(count);
}
}