class Animal{
	String name="����";
	void shout(){
		System.out.println("���﷢������");
	}
}
class Dog extends Animal{
	String name="Ȯ��";
	void shout(){   //��д�����shout����
		super.shout();   //���ʸ���ĳ�Ա����
	}
	void printName(){
		System.out.println("name="+super.name);   //���ʸ���ĳ�Ա����
	}
}
public class example22{
	public static void main(String[] args){
		Dog dog=new Dog();
		dog.shout();
		dog.printName();
	}
}