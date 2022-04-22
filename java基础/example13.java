class Phone{  
	String brand;
	double price;
	String colour;
	public void call(String who){
	System.out.println("打电话给"+who);
	}
	public void message(){
		System.out.println("群发消息");
	}
}
public class example13{
	public static void main(String[] args){
		Phone one=getphone();
		System.out.println(one.brand);
		System.out.println(one.price);
		System.out.println(one.colour);
	}
	public static Phone getphone(){   //使用对象类型作为方法返回值
		Phone two=new Phone();
		two.brand="苹果";
		two.price=8388.0;
		two.colour="黑色";
		return two;
		
	}
}