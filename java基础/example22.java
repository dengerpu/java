class Animal{
	String name="动物";
	void shout(){
		System.out.println("动物发出叫声");
	}
}
class Dog extends Animal{
	String name="犬类";
	void shout(){   //重写父类的shout方法
		super.shout();   //访问父类的成员方法
	}
	void printName(){
		System.out.println("name="+super.name);   //访问父类的成员变量
	}
}
public class example22{
	public static void main(String[] args){
		Dog dog=new Dog();
		dog.shout();
		dog.printName();
	}
}