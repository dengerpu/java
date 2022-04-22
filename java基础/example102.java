import java.util.Scanner;
public class example102{
	public static void main(String[] args){
		System.out.println("ÇëÊäÈë×Ö·û´®");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String str="";
		char[] a=s.toCharArray();
		for(int i=a.length-1;i>=0;i--)
			str+=a[i];
		System.out.println("×Ö·û´®·´×ª½á¹û");
		System.out.println(str);
}
}