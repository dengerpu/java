public class example55{
	public static void main(String[] args){
		String str="2018-01-24";
		System.out.println("�ӵ�6���ַ���ȡ��ĩβ�Ľ��:"+str.substring(5));
		System.out.println("�ӵ�6���ַ���ȡ����7���ַ��Ľ��"+str.substring(5,7));
		System.out.println("�ָ����ַ��������е�Ԫ������Ϊ:");
		String[] strArray=str.split("-");//ͨ����������-�����ַ�����Ϊ�ַ�������
		for(int i=0;i<strArray.length;i++){
			if(i!=strArray.length-1)
				System.out.print(strArray[i]+"��");
				else
					System.out.print(strArray[i]);
			
		}
	}
}