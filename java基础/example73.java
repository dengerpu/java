import java.time.*;
import java.time.format.*;
public class example73{
	public static void main(String[] args){
		String str1="2018-01-27 12:38:36";
		String str2="2018/年01月29日15时01分20秒";
		DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
		DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
		LocalDateTime localDateTime1=LocalDateTime.parse(str1,formatter1);
		LocalDateTime localDateTime2=LocalDateTime.parse(str2,formatter2);
		System.out.println(localDateTime1);
		System.out.println(localDateTime2);
	}
}