import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class example114{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer>list=new ArrayList<>();
		Collections.addAll(list,-3,1,2,5,4);
		System.out.println("�����е�Ԫ�أ�"+list);
		System.out.println("�����е����Ԫ��"+Collections.max(list));
		System.out.println("����������Ԫ��"+Collections.min(list));
		Collections.replaceAll(list,-3,0);		//�������е�-3��0�滻��
		System.out.println("�滻��ļ���:"+list);
		Collections.sort(list);
		System.out.println("���������Ϊ:"+list);
		System.out.println("������Ҫ���ҵ�Ԫ��");
		int n=sc.nextInt();
		System.out.println("����ͨ�����ֲ��ҷ�����Ԫ��"+n+"����λ��Ϊ:"+Collections.binarySearch(list,n));
		
	}
}