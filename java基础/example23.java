class Animal{
	public Animal(String name){
		System.out.println("����һֻ"+name);
	}
	public Animal(){
		System.out.println("����һֻ����");
	}
}
class Dog extends Animal{
	public Dog(){
		//super("ƤƤϺ");
		super();
	}
}
public class example23{
	public static void main(String[] args){
		Dog dog=new Dog();
	}
}