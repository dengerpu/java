import java.text.*;
import java.util.*;
public class example72{
	public static void main(String[] args){
		SimpleDateFormat sdf=new SimpleDateFormat("Gyyyy��MM��dd�գ�������yyyy��ĵ���,E");
		System.out.println(sdf.format(new Date()));
	}
}