interface Animal{
	int ID=1;             									//����ȫ�ֳ���
	void breathe();  										//������󷽷�breathe()
	default void getType(String type){  					//����һ��Ĭ�Ϸ���
		System.out.println("�ö�������"+type);
	}
	static int getID(){  									 //����һ����̬����
		return Animal.ID;
	}
}
class Dog implements Animal{                                 //Dog��ʵ��Animal�ӿ�
	
	public void breathe(){
		System.out.println("���ں���");
	}
}
public class example27{
	public static void main(String[] args){
		System.out.println(Animal.getID());
		Dog dog=new Dog();
		System.out.println(dog.ID);
		dog.breathe();
		dog.getType("Ȯ��");
		
	}
}