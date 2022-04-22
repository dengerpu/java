public class example65{
	public static void main(String[] args){
	int num=123;
	String string=String.valueOf(num);
	System.out.println("将int变量转化为字符的结果"+string);
	String str="998";
	Integer integer=Integer.valueOf(num);
	Integer integer2=Integer.valueOf(str);
	System.out.println("将int变量转换为包装类的结果"+integer);
	System.out.println("将字符串常量转换为包装类的结果"+integer2);
	Integer integer3=new Integer(num);
	Integer integer4=new Integer(str);
	System.out.println("通过构造器将int变量换为包装类的结果"+integer3);
	System.out.println("通过构造器将字符串变量换为包装类的结果"+integer4);
	}
}