public class example60{
	public static void main(String[] args){
		Runtime rt=Runtime.getRuntime();
		System.out.println("�������ĸ���"+rt.availableProcessors()+"��");
		System.out.println("�ռ��ڴ��С"+rt.freeMemory()/1024/1024+"M");
		System.out.println("�������ڴ��С"+rt.maxMemory()/1024/1024+"M");
	}
}