import java.util.Scanner;
public class example119{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int i,sum,j;
	for(i=2;i<=n;i++)
	{
		sum=0;
		for(j=2;j<i;j++)
			if(i%j==0)
				sum+=j;
		if(sum==i)
			System.out.println(sum);
	}
	}
}
