public class example52{
public static void main(String[] args){
   String str="java";
   char[] charArray=str.toCharArray();
   System.out.println("���ַ���ת��Ϊ�ַ�����ı���");
   for(int i=0;i<charArray.length;i++){
	   if(i!=charArray.length-1)
		   System.out.print(charArray[i]+",");
	   else
		   System.out.print(charArray[i]);
   }
   System.out.println("��intת��ΪString����֮��Ľ��:"+String.valueOf(12));
   System.out.println("���ַ���ת��Ϊ��д֮��Ľ��"+str.toUpperCase());//���ַ�����Сдת��Ϊ��д
}
}