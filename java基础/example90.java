public class example90{
	public static void main(String[] args){
	 String[] strs={"aaa","bbb","ccc"};
	 for(String str:strs)
		 str="ddd";
	 System.out.println("foreach循环修改后的数组"+strs[0]+strs[1]+strs[2]);
	}
	
}