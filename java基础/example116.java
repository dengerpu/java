import java.util.Arrays;
public class example116{
	public static void main(String[] args){
		int []arr={0,2,3,5,1,4};		
		int []arr1=Arrays.copyOfRange(arr,1,7);		//�������飬����ǰ�棬����������
		Arrays.fill(arr,8);						//�滻�����е�����Ԫ��
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+",");
		System.out.println();
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr1[i]+",");
	}
}