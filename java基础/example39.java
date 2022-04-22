interface Animal{
	void shout();
}
public class example39{
	public static void main(String[] args)
	{
		String name="小花";
		animalshout(new Animal(){
			public void shout(){
				System.out.println("匿名内部类输出："+name+"喵喵...");
			}
		});
		animalshout(()->System.out.println("lambda表达式输出"+name+"喵喵喵..."));
	}
	public static void animalshout(Animal an){
		an.shout();
	}
}