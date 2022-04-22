import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		String s=sc.nextLine();
		char c = s.charAt(0);
		int b=sc1.nextInt();
		int a=Integer.valueOf(c);   //将字符转化为整数   
		System.out.println(a);
		a=(a-96+b)%26+96;
		String s1=String.valueOf(a);  //将整数转化为字符
		System.out.println(s1);
	}
}