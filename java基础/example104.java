public class example104{
	public static void main(String[] args){
		/*
		* public StringBuffer();  �޲ι��췽��v
		* public StringBuffer(int capacity): ָ���������ַ�������������
		* public StringBuffer��String str��:ָ���ַ������ݵ��ַ�������������
		* StringBuffer�ķ�����
		* public int capacity():���ص�ǰ����           ����ֵ
		* public int length():���س���                 ʵ��ֵ
		*/
		StringBuffer s=new StringBuffer();
		System.out.println(s.capacity());
		System.out.println(s.length());
		
		
		StringBuffer s1=new StringBuffer(10);
		System.out.println(s1.capacity());
		System.out.println(s1.length());
		
		
		StringBuffer s2=new StringBuffer("abcdef");
		System.out.println(s2.capacity());
		System.out.println(s2.length());
	}
	
}