class Phone{   //������һ������ΪPhone���࣬classǰ���public���Բ�д����д�Ļ�Ĭ��Ϊpublic����Ҳ�������������η�
	/*�����Ա����*/
	String brand;
	double price;
	String colour;
	/*�����Ա����*/
	public void call(String who){//���η�����ֱ�Ӳ�д  ֱ��д��void call()
	System.out.println("��绰��"+who);
	}
	public void message(){
		System.out.println("Ⱥ����Ϣ");
	}
}
public class example12{
	public static void main(String[] args){
		//һ���ಢ����ֱ��ʹ�ã���Ҫ�����ഴ��һ���������ʹ�ã�
		Phone one=new Phone();  //����һ������
		one.brand="ƻ��";
		one.price=8388.0;
		one.colour="��ɫ";
		System.out.println(one.brand);
		System.out.println(one.price);
		System.out.println(one.colour);
		System.out.println("==========");
		one.call("�ǲ�˹");
		one.message();

	}
	
}