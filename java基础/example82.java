import java.util.ArrayList;
public class example82{
	public static void main(String[] args){
		ArrayList list=new ArrayList();
		list.add("stud1");
		list.add("stud2");
		list.add("stud3");
		for(Object obj:list){
			System.out.println(obj);
		}
	}
}