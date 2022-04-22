abstract class Animal{
	public abstract void shout();
}
class Dog extends Animal{
	public void shout(){
		System.out.println("ÍôÍô....");
	}
}
public class example26{
	public static void main(String[] args){
		Dog dog=new Dog();
		dog.shout();
	}
}`