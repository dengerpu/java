class outer{
	int m=10;
	class inner{
		int m=20;
		public void show(){
			int m=30;
			System.out.println("m="+m);
			System.out.println("m="+this.m);
			System.out.println("m="+outer.this.m);    //�ⲿ������+this+��������
			
		}
	}
}
public class example36{
	public static void main(String[] args){
		outer.inner an=new outer().new inner();
		an.show();
	} 
}