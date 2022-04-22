interface jiekou{
	public abstract void method();    //定义一个抽象方法
	public default void  method1(){
		System.out.println("调用了接口的默认方法");
	}
	public static void method2(){
		System.out.println("调用了接口的静态方法");
	}
	
public default void method3(){
	System.out.println("默认方法1");
	//method5();
}
public default void method4(){
	System.out.println("默认方法2");
	//method5();
}
/*private void method5(){              //普通私有方法，解决多个默认方法代码直接重复问题  private+返回值类型+方法名称（）{方法体}  
	System.out.println("AAA");
	System.out.println("BBB");
	System.out.println("CCC");
}*/
public static void method6(){
	System.out.println("静态方法1");
	method8();
}
public static void method7(){
	System.out.println("静态方法2");
	method8();
}
private static void method8(){              //私有静态方法，解决多个静态方法代码直接重复问题  private+static+返回值类型+方法名称（）{方法体}  
	System.out.println("AAA");
	System.out.println("BBB");
	System.out.println("CCC");
}
}
class jiekoulei implements jiekou{
	public void method(){
		System.out.println("调用了接口的抽象方法");
	}
}
public class example33{
	public static void main(String[] args){
		jiekoulei abc=new jiekoulei();
		abc.method();
		abc.method1();
		jiekou.method2();
		abc.method3();
		abc.method4();
		jiekou.method6();
		jiekou.method7();
	}
}