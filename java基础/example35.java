class Outer{
	int m=0;
	void test1(){
		System.out.println("�ⲿ���Ա����");
	}
	class Inner{
		int n=1;
		void show1(){
			System.out.println("�ⲿ���Ա����m="+m);
			test1();
		}
		void show2(){
			System.out.println("�ڲ����Ա����");
		}
	}
	void test2(){
		Inner inner=new Inner();
		System.out.println("�ڲ����Ա����n="+inner.n);
		inner.show2();
	}
}
public class example35{
	public static void main(String[] args){
		Outer outer=new Outer();
		Outer.Inner inner=outer.new Inner();
		inner.show1();
		outer.test2();
	}
}