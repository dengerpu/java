import java.text.*;
import java.util.*;
public class example71{
	public static void main(String[] args){
		Date date=new Date();
		DateFormat fullFormat=DateFormat.getDateInstance(DateFormat.FULL);
		DateFormat longFormat=DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
		System.out.println("��ǰ���ڵ�������ʽΪ:"+fullFormat.format(date));
		System.out.println("��ǰ���ڵĳ���ʽΪ:"+longFormat.format(date));
	}
}