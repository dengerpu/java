interface Animal{
	int ID=1;             									//定义全局常量
	void breathe();  										//定义抽象方法breathe()
	default void getType(String type){  					//定义一个默认方法
		System.out.println("该动物属于"+type);
	}
	static int getID(){  									 //定义一个静态方法
		return Animal.ID;
	}
}
class Dog implements Animal{                                 //Dog类实现Animal接口
	
	public void breathe(){
		System.out.println("狗在呼吸");
	}
}
public class example27{
	public static void main(String[] args){
		System.out.println(Animal.getID());
		Dog dog=new Dog();
		System.out.println(dog.ID);
		dog.breathe();
		dog.getType("犬科");
		
	}
}