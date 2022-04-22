interface Calculate{
	int calc(int num);
}
class Math{
	public static int abs(int num){
		if(num<0)
			return -num;
		else
			return num;
	}
}
public class example43{
	public static void printabs(int num,Calculate calculate){
		System.out.println(calculate.calc(num));
	}
	public static void main(String[] args)	{
		printabs(-10,n->Math.abs(n));
		printabs(-10,Math::abs);
	}
}