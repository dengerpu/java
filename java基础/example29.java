class fu{
	public fu(){
	System.out.println("�����˸���Ĺ��췽��");
	}
}
class zi extends fu{
	public zi(){
	//super();���Բ�д��д�Ļ�������ڵ�һλ�����๹�췽������ֱ�ӵ��ø��๹�췽��������������޲εĹ��췽��
	System.out.println("����������Ĺ��췽��");
	}
}
public class example29{
	public static void main(String[] args){
		zi zilei=new zi();
	}
}