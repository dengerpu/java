interface Animal{
	public void shout();
}
public class example41{
	public static void main(String[] args){
		String name="С��";
		animalshout(new Animal(){
			public void shout(){
				System.out.println("�����ڲ����ʵ��:"+name);
			}
		});
		animalshout(()->{System.out.println("Lambda���ʽ���:"+name);
		//System.out.println("�����������");
		});
	}
	public static void animalshout(Animal an){
		an.shout();
	}
}