interface Animal{
	void shout();
}
interface Calculate{
	int sum(int a,int b);
}
public class example42{
	public static void main(String[] args)
	{
		animalshout(()->System.out.println("无参，无返回值的函数式接口调用"));
		showsum(10,20,(x,y)->x+y);
	}
	public static void animalshout(Animal an){
		an.shout();
	}
	public static void showsum(int x,int y,Calculate calculate)
	{
		System.out.println(x+"+"+y+"的和为:"+calculate.sum(x,y));
	}
}