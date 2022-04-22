interface Animal{
	void shout();
}
public class example37{
	public static void main(String[] args)
	{
		Animal animal=new Animal(){
			void show(){
				System.out.println("匿名类实现了接口方法");
			}
		};
		animal.show();
	}
}