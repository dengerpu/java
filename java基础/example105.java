public class example105{
	public static void main(String[] args){
		/**
		*public StringBuffer append(String str):���԰��������͵�������ӵ��ַ����Ļ�������
		*public StringBuffer insert(int offset,String str): ��ָ��λ�ð��������͵����ݲ��뵽�ַ�����������������ַ�������������
		*/
		StringBuffer sb=new StringBuffer();
		StringBuffer sb2=sb.append("heima");
		StringBuffer sb3=sb.append(100);
		
		
		System.out.println(sb.toString());
		System.out.println(sb2.toString());
		System.out.println(sb3.toString());
		
		sb.insert(0,"1234");
		System.out.println(sb.toString());
	}
	
}