class Animal{
	String name;
	void shout(){
		System.out.println("动物发出叫声");
	}
}
class Dog extends Animal{
	public void printName(){
		System.out.println("name="+name);
		}
		void shout(){   //子类可以重写父类方法
			System.out.println("汪汪");
		}
	
}
public class example21{
	public static void main(String[] args){
		Dog dog=new Dog();
		dog.name="沙皮狗";
		dog.printName();
		dog.shout();
	}
}