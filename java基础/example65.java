public class example65{
	public static void main(String[] args){
	int num=123;
	String string=String.valueOf(num);
	System.out.println("��int����ת��Ϊ�ַ��Ľ��"+string);
	String str="998";
	Integer integer=Integer.valueOf(num);
	Integer integer2=Integer.valueOf(str);
	System.out.println("��int����ת��Ϊ��װ��Ľ��"+integer);
	System.out.println("���ַ�������ת��Ϊ��װ��Ľ��"+integer2);
	Integer integer3=new Integer(num);
	Integer integer4=new Integer(str);
	System.out.println("ͨ����������int������Ϊ��װ��Ľ��"+integer3);
	System.out.println("ͨ�����������ַ���������Ϊ��װ��Ľ��"+integer4);
	}
}