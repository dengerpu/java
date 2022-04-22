class Animal{
	//定义动物叫的方法
	void shout(){
		System.out.println("动物叫");
	}
}
public class example24{
	public static void main(String[] args){
		Animal animal=new Animal();
		System.out.println(animal.toString());
	}
}