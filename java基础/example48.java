public class example48{
	public static void printage(int age)throws Exception{
		if(age<=0){
			throw new Exception("������������󣬱�����������");
		}
		else
			System.out.println("��������Ϊ"+age);
	}
	public static void main(String[] args){
		int age=-1;
		try{
			printage(age);
		}catch(Exception e){
			System.out.println("�������ϢΪ:"+e.getMessage());
		}
	}
}