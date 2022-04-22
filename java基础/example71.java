import java.text.*;
import java.util.*;
public class example71{
	public static void main(String[] args){
		Date date=new Date();
		DateFormat fullFormat=DateFormat.getDateInstance(DateFormat.FULL);
		DateFormat longFormat=DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
		System.out.println("当前日期的完整格式为:"+fullFormat.format(date));
		System.out.println("当前日期的长格式为:"+longFormat.format(date));
	}
}