import java.util.HashSet;
public class example91{
	public static void main(String[] args){
	HashSet set=new HashSet();
	set.add("jack");
	set.add("eve");
	set.add("rose");
	set.add("rose");
	set.forEach(o->System.out.println(o));
	}
}