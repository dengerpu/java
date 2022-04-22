class Animal{
	public Animal(String name){
		System.out.println("我是一只"+name);
	}
	public Animal(){
		System.out.println("我是一只动物");
	}
}
class Dog extends Animal{
	public Dog(){
		//super("皮皮虾");
		super();
	}
}
public class example23{
	public static void main(String[] args){
		Dog dog=new Dog();
	}
}