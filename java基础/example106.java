public class example106{
	public static void main(String[] args){
		/**
		* public StringBuffer deleteCharAt(int index):ɾ��ָ��λ�õ��ַ��������ر���
		* public StringBuffer delete(int start,int end): ɾ����ָ��λ�ÿ�ʼָ��λ�ý��������ݣ������ر���
		* public StringBuffer repleace(int start,int end,String str):��str��ʼ��end��str���滻
		* public StringBuffer reverse();ʵ���ַ����ķ�ת
		* public String substring(int start):��ָ��λ�ý�ȡ��ĩβ
		* public String substring(int strat,int end):��ȡ��ָ��λ�ÿ�ʼ��������ʼλ�ã�����������Ϊֹ
		*
		*/
		StringBuffer sb=new StringBuffer("hei123ma");
		sb.deleteCharAt(3);
		System.out.println(sb);
		sb.delete(3,5);
		System.out.println(sb);
		sb.replace(0,3,"bai");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		StringBuffer sb1=new StringBuffer("1woaiheima");
		String str=sb1.substring(1);
		System.out.println(str);
	}
}