interface Shape{
	double area(double a);
}
class Square implements Shape{
	public double area(double a){
		System.out.println("�����ε����Ϊ"+a*a);
		return a*a;
	}
}
class Circle implements Shape{
	public double area(double a){
		System.out.println("Բ�����Ϊ"+3.14*a*a);
		return 3.14*a*a;
	}
	
}
public class example50{
	public static void main(String[] args){
		Square square=new Square();
		square.area(2);
		Circle circle=new Circle();
		circle.area(3);
	}
}