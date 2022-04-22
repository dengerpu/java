class fu{
	public fu(){
	System.out.println("调用了父类的构造方法");
	}
}
class zi extends fu{
	public zi(){
	//super();可以不写，写的话必须放在第一位，子类构造方法可以直接调用父类构造方法，父类必须是无参的构造方法
	System.out.println("调用了子类的构造方法");
	}
}
public class example29{
	public static void main(String[] args){
		zi zilei=new zi();
	}
}