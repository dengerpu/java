import java.util.Arrays;
public class example115{
	public static void main(String[] args){
		int[] arr={0,2,5,4,1,3};
		printArray(arr);			//��ӡԭ����
		Arrays.sort(arr);			//����
		printArray(arr);			//��ӡ����������
		}
		public static void printArray(int []arr){
			System.out.print("[");
			for(int i=0;i<arr.length-1;i++)
				System.out.print(arr[i]+",");
			System.out.println(arr[arr.length-1]+"]");
		}
	
}