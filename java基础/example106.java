public class example106{
	public static void main(String[] args){
		/**
		* public StringBuffer deleteCharAt(int index):删除指定位置的字符，并返回本身
		* public StringBuffer delete(int start,int end): 删除从指定位置开始指定位置结束的内容，并返回本身
		* public StringBuffer repleace(int start,int end,String str):从str开始到end用str人替换
		* public StringBuffer reverse();实现字符串的反转
		* public String substring(int start):从指定位置截取到末尾
		* public String substring(int strat,int end):截取从指定位置开始，包括开始位置，不包括结束为止
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