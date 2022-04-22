public class example05{
	public static int add01(int x,int y){
		return x+y;
	}
	public static int add02(int x,int y,int z){
		return x+y+z;
	}
	public static double add03(double x,double y){
		return x+y;
	}
	public static void main(String[] args){
		int sum1=add01(1,2);
		int sum2=add02(3,4,7);
		double sum3=add03(0.2,5.3);
		System.out.println("sum1="+sum1+"\n"+"sum2="+sum2+"\n"+"sum3="+sum3);
	}
}