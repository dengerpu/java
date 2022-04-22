import java.util.Arrays;
public class example116{
	public static void main(String[] args){
		int []arr={0,2,3,5,1,4};		
		int []arr1=Arrays.copyOfRange(arr,1,7);		//复制数组，包括前面，不包括后面
		Arrays.fill(arr,8);						//替换数组中的所有元素
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+",");
		System.out.println();
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr1[i]+",");
	}
}