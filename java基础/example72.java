import java.text.*;
import java.util.*;
public class example72{
	public static void main(String[] args){
		SimpleDateFormat sdf=new SimpleDateFormat("Gyyyy年MM月dd日：今天是yyyy年的第天,E");
		System.out.println(sdf.format(new Date()));
	}
}