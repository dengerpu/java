import java.util.TreeSet;
public class example93{
	public static void main(String[] args){
		TreeSet ts=new TreeSet();           //����TreeSet����
		ts.add(3);
		ts.add(9);
		ts.add(1);
		ts.add(21);
		System.out.println("������TreeSet����Ϊ:"+ts);
		System.out.println("TreeSet������Ԫ��Ϊ"+ts.first());
		System.out.println("����β��Ԫ��"+ts.last());
		System.out.println("������С�ڵ���9�����һ��Ԫ��Ϊ:"+ts.floor(9));
		System.out.println("�����д���10����Сһ��Ԫ��Ϊ"+ts.higher(10));
		System.out.println("�����д���100����С��һ��Ԫ��Ϊ"+ts.higher(100));
		Object first=ts.pollFirst();
		System.out.println("ɾ���ĵ�һ��Ԫ����"+first);
		System.out.println("ɾ���ĵ�һ��Ԫ�غ�TreeSet���ϱ�Ϊ"+ts);
		
	}
}