import java.util.*;
public class example68{
	public static void main(String[] args){
		Calendar calendar=Calendar.getInstance();
		calendar.set(2018,1,1);
		calendar.add(Calendar.DATE,100);
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH);
		int date2=calendar.get(Calendar.DATE);
		System.out.println("�ƻ���������Ϊ:"+year+"��"+month+"��"+date+"��");
	}
}