class Phone{   //定义了一个类名为Phone的类，class前面的public可以不写（不写的话默认为public），也可以是其他修饰符
	/*定义成员变量*/
	String brand;
	double price;
	String colour;
	/*定义成员方法*/
	public void call(String who){//修饰符可以直接不写  直接写成void call()
	System.out.println("打电话给"+who);
	}
	public void message(){
		System.out.println("群发消息");
	}
}
public class example12{
	public static void main(String[] args){
		//一个类并不能直接使用，需要根据类创建一个对象才能使用；
		Phone one=new Phone();  //创建一个对象
		one.brand="苹果";
		one.price=8388.0;
		one.colour="黑色";
		System.out.println(one.brand);
		System.out.println(one.price);
		System.out.println(one.colour);
		System.out.println("==========");
		one.call("乔布斯");
		one.message();

	}
	
}