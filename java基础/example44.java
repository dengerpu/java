interface printable{
	void print(String str);
}
class Stringutils{
	public void printuppercase(String str){
		System.out.println(str.toUpperCase());
	
	}
}
public class example44{
	public static void printupper(String next,printable pt){
		pt.print(next);
	}
	public static void main(String[] args){
		Stringutils stu=new Stringutils();
		printupper("hello",t->stu.printuppercase(t));
		printupper("hello",stu::printuppercase);
	}
}