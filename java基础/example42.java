interface Animal{
	void shout();
}
interface Calculate{
	int sum(int a,int b);
}
public class example42{
	public static void main(String[] args)
	{
		animalshout(()->System.out.println("�޲Σ��޷���ֵ�ĺ���ʽ�ӿڵ���"));
		showsum(10,20,(x,y)->x+y);
	}
	public static void animalshout(Animal an){
		an.shout();
	}
	public static void showsum(int x,int y,Calculate calculate)
	{
		System.out.println(x+"+"+y+"�ĺ�Ϊ:"+calculate.sum(x,y));
	}
}