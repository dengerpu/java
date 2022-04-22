interface Animal{
	public void shout();
}
public class example41{
	public static void main(String[] args){
		String name="小花";
		animalshout(new Animal(){
			public void shout(){
				System.out.println("匿名内部类的实现:"+name);
			}
		});
		animalshout(()->{System.out.println("Lambda表达式输出:"+name);
		//System.out.println("输出哈哈哈哈");
		});
	}
	public static void animalshout(Animal an){
		an.shout();
	}
}