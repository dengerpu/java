interface Animmal{
	void shout();
}
interface Calculate{
	int sum(int a,int b);
}
public class example40{
	public static void main(String[] args){
		animal(()->System.out.println("�޲Σ��޷���ֵ�ĺ���ʽ�ӿڵ���"))��
		showsum(10,20,(x,y)->x+y);
	}
	private static void animalshout(Animal animal){
		animal.shout();
	}
	private static void showsum(int x,int y,Calculate calculate){
		System.out.println(x+"+"+y+"�ĺ�Ϊ��"+calculate.sum(x,y));
	}
}