import java.time.*;
public class example70{
	public static void main(String[] args){
		Clock clock=Clock.systemUTC();
		System.out.println("��ȡUTCʱ��ת���ĵ�ǰʱ��"+clock.instant());
	}
}