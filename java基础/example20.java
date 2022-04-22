public class example20{
	public static void main(String[] args){
		int a=fasic(6);
	System.out.println(a);
	}
	public static int fasic(int n){
		if(n==1)
			return 0;
		else
			if(n==2||n==3)
				return 1;
			else
				return fasic(n-1)+fasic(n-2);
	
	
	}
}