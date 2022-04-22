public class example52{
public static void main(String[] args){
   String str="java";
   char[] charArray=str.toCharArray();
   System.out.println("将字符串转化为字符数组的遍历");
   for(int i=0;i<charArray.length;i++){
	   if(i!=charArray.length-1)
		   System.out.print(charArray[i]+",");
	   else
		   System.out.print(charArray[i]);
   }
   System.out.println("将int转化为String类型之后的结果:"+String.valueOf(12));
   System.out.println("将字符串转化为大写之后的结果"+str.toUpperCase());//将字符串的小写转化为大写
}
}