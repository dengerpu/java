class Phone{  
	String brand;
	double price;
	String colour;
	public void call(String who){
	System.out.println("��绰��"+who);
	}
	public void message(){
		System.out.println("Ⱥ����Ϣ");
	}
}
public class example14{
	public static void main(String[] args){
		Phone one=new Phone();
		one.brand="ƻ��";
		one.price=8388.0;
		one.colour="������";
		getphone(one);
	}
	public static void getphone(Phone two){
		System.out.println(two.brand);
		System.out.println(two.price);
		System.out.println(two.colour);
	}
}