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
public class example13{
	public static void main(String[] args){
		Phone one=getphone();
		System.out.println(one.brand);
		System.out.println(one.price);
		System.out.println(one.colour);
	}
	public static Phone getphone(){   //ʹ�ö���������Ϊ��������ֵ
		Phone two=new Phone();
		two.brand="ƻ��";
		two.price=8388.0;
		two.colour="��ɫ";
		return two;
		
	}
}