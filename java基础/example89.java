import java.util.Scanner;
public class example89{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int i;
		char[] arr=str.toCharArray();
		for(i=str.length()-1;i>=0;i--){
			
			if(arr[i]>='a'&&arr[i]<='z')
				arr[i]-=32;
			else if(arr[i]>='A'&&arr[i]<='Z')
				arr[i]+=32;
			
		}
		System.out.print(arr.toString());
	}
	
}