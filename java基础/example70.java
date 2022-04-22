import java.time.*;
public class example70{
	public static void main(String[] args){
		Clock clock=Clock.systemUTC();
		System.out.println("获取UTC时区转换的当前时间"+clock.instant());
	}
}