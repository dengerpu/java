public class example83{
	public static void main(String[] args){
		String[] strs={"aaa","bbb","ccc"};
		for(String str: strs)
			str="ddd";
		for (Object obj:strs){
			System.out.println(obj);
		}
		for(int i=0;i<strs.length;i++)
			strs[i]="ddd";
		for(int i=0;i<strs.length;i++)
			System.out.println(strs[i]);
	}
}