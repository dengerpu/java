interface jiekou{    								//����һ���ӿ�
	public abstract void method();  				//����һ�����󷽷���public abstract������ʡ��
	public default void method1(){
		System.out.println("ʵ���˽ӿڵ�Ĭ�Ϸ���");  //����һ���ӿڵ�Ĭ�Ϸ���
	}
	public static void method2(){
		System.out.println("ʵ���˽ӿڵľ�̬����");    //�ӿڷ�������ͨ������ʹ�ã�ֱ�ӽӿ�.��̬�����Ϳ����ˣ�����
	}
}
class shixianlei implements jiekou{
	public void method(){
		System.out.println("ʵ���˽ӿڵĳ��󷽷�");
	}
	public void method1(){     //�������Ҳ���Բ�д
		System.out.println("������д�˽ӿڵ�Ĭ�Ϸ���");
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