import java.util.HashSet;
public class example86{
	public static void main(String[] args){
		HashSet set=new HashSet();                       //所存储的元素是不可重复的，并且元素都是无序的
		set.add("jack");
		set.add("eve");
		set.add("rose");
		set.add("rose");
		set.forEach(o->System.out.println(o));
	}
	}