public class example51{
	public static void main(String[] args){
		String s="abcdabcddfffdsasc";
		System.out.println("�ַ����ĳ���Ϊ"+s.length());
		System.out.println("�ַ����е�һ���ַ�:"+s.charAt(0));
		System.out.println("�ַ������ַ�c��һ�γ��ֵ�λ��"+s.indexOf('c'));
		System.out.println("�ַ������ַ�C���һ�γ��ֵ�λ��"+s.lastIndexOf('c'));
		System.out.println("�ַ��������ַ�����һ�γ��ֵ�λ��"+s.indexOf("ab"));
		System.out.println("�ַ��������ַ������һ�γ��ֵ�λ��"+s.lastIndexOf("ab"));
		
	}
}