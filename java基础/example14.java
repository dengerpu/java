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
public class example14{
	public static void main(String[] args){
		Phone one=new Phone();
		one.brand="苹果";
		one.price=8388.0;
		one.colour="土豪金";
		getphone(one);
	}
	public static void getphone(Phone two){
		System.out.println(two.brand);
		System.out.println(two.price);
		System.out.println(two.colour);
	}
}