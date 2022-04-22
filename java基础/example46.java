interface printable{
	void print(stringutils su,String str);
}
class stringutils{
	public void printupppercase(String str){
		System.out.println(str.toUpperCase());
	}
}
public class example46{
	private static void printupper(stringutils su,String text,printable pt){
		pt.print(su,text);
	}
	public static void main(String[] args){
		printupper(new stringutils(),"hello",(object,t)->object.printupppercase(t));
		printupper(new stringutils(),"hello",stringutils::printupppercase);
	}
}