interface jiekou{
	public abstract void shout();   //定义一个抽象方法
}
class jiekoulei implements jiekou{
	public void shout(){
		System.out.println("执行了接口的抽象方法");
	}
	public void speak(){
		System.out.println("测试哈哈哈哈");
	}
}
class dog implements jiekou{
	public void shout(){
		System.out.println("测试");
	}
}
public class example34{
	public static void main(String[] args){
		jiekou an1=new jiekoulei();
		an1.shout();
		// an1.speak();				这样的话是错误的，要使用向下转换必须强制转化
		jiekoulei an2=(jiekoulei)an1;
		an2.shout();
		an2.speak();
		System.out.println("===========");
		jiekou an3=new jiekoulei();
		if(an3 instanceof dog){
			dog an4=(dog) an3 ;
			an4.shout();
		}else
			System.out.println("该类型的对象不是dog类型");
		
	}
}