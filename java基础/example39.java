interface Animal{
	void shout();
}
public class example39{
	public static void main(String[] args)
	{
		String name="С��";
		animalshout(new Animal(){
			public void shout(){
				System.out.println("�����ڲ��������"+name+"����...");
			}
		});
		animalshout(()->System.out.println("lambda���ʽ���"+name+"������..."));
	}
	public static void animalshout(Animal an){
		an.shout();
	}
}