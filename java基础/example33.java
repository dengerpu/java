interface jiekou{
	public abstract void method();    //����һ�����󷽷�
	public default void  method1(){
		System.out.println("�����˽ӿڵ�Ĭ�Ϸ���");
	}
	public static void method2(){
		System.out.println("�����˽ӿڵľ�̬����");
	}
	
public default void method3(){
	System.out.println("Ĭ�Ϸ���1");
	//method5();
}
public default void method4(){
	System.out.println("Ĭ�Ϸ���2");
	//method5();
}
/*private void method5(){              //��ͨ˽�з�����������Ĭ�Ϸ�������ֱ���ظ�����  private+����ֵ����+�������ƣ���{������}  
	System.out.println("AAA");
	System.out.println("BBB");
	System.out.println("CCC");
}*/
public static void method6(){
	System.out.println("��̬����1");
	method8();
}
public static void method7(){
	System.out.println("��̬����2");
	method8();
}
private static void method8(){              //˽�о�̬��������������̬��������ֱ���ظ�����  private+static+����ֵ����+�������ƣ���{������}  
	System.out.println("AAA");
	System.out.println("BBB");
	System.out.println("CCC");
}
}
class jiekoulei implements jiekou{
	public void method(){
		System.out.println("�����˽ӿڵĳ��󷽷�");
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