interface jiekou{    								//创建一个接口
	public abstract void method();  				//定义一个抽象方法，public abstract，可以省略
	public default void method1(){
		System.out.println("实现了接口的默认方法");  //定义一个接口的默认方法
	}
	public static void method2(){
		System.out.println("实现了接口的静态方法");    //接口方法不能通过对象使用，直接接口.静态方法就可以了（）；
	}
}
class shixianlei implements jiekou{
	public void method(){
		System.out.println("实现了接口的抽象方法");
	}
	public void method1(){     //这个方法也可以不写
		System.out.println("覆盖重写了接口的默认方法");
	}
}
public class example32{
	public  static void main(String[] args){
		shixianlei cer=new shixianlei();
		cer.method();
		cer.method1();
		jiekou.method2();
	}
}