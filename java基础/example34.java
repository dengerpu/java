interface jiekou{
	public abstract void shout();   //����һ�����󷽷�
}
class jiekoulei implements jiekou{
	public void shout(){
		System.out.println("ִ���˽ӿڵĳ��󷽷�");
	}
	public void speak(){
		System.out.println("���Թ�������");
	}
}
class dog implements jiekou{
	public void shout(){
		System.out.println("����");
	}
}
public class example34{
	public static void main(String[] args){
		jiekou an1=new jiekoulei();
		an1.shout();
		// an1.speak();				�����Ļ��Ǵ���ģ�Ҫʹ������ת������ǿ��ת��
		jiekoulei an2=(jiekoulei)an1;
		an2.shout();
		an2.speak();
		System.out.println("===========");
		jiekou an3=new jiekoulei();
		if(an3 instanceof dog){
			dog an4=(dog) an3 ;
			an4.shout();
		}else
			System.out.println("�����͵Ķ�����dog����");
		
	}
}