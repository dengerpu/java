/*
���󷽷������Ǽ���abstract�ؼ��ʣ�Ȼ��ȥ��������ֱ�ӷֺŽ���
�����ࣺ���󷽷����ڵ��࣬�����ǳ�������С���class֮ǰд��abstract����

���ʹ�ó�����ͳ��󷽷���
1.����ֱ�Ӵ���new������
2.������һ���������̳г�����
3.������븲�ǳ����׵��е����еĳ��󷽷�
4.��������������ʹ��
*/

abstract class Animal{
	public abstract void eat();
}
class Cat extends Animal{
	public void eat(){
		System.out.println("è����");
	}
}
public class example30{
	public static void main(String[] args){
		Cat cat=new Cat();
		cat.eat();
	}
}