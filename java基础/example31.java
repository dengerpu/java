abstract class Animal{
	public abstract void shout();
}
class Cat extends Animal{
	public void shout(){
		System.out.println("ß÷ß÷ß÷...");
	}
}
class Dog extends Animal{
	public void shout(){
		System.out.println("ÍôÍôÍô...");
	}
}
public class example31{
	public static void main(String[] args){
		Cat cat=new Cat();
		Dog dog=new Dog();
		cat.shout();
		dog.shout();
	}
}