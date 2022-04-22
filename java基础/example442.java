interface Shape{
	double area(double a);

}
class Square implements Shape{
	public double area(double a){
	return a*a;
	}
}
class Circle implements Shape{
	public double area(double a){
		return 3.14*a*a;
	}
}
public class example442{
	public static void main(String[] args){
		Shape square=new Square();
		Shape circle=new Circle();
		System.out.println(square.area(2));
		System.out.println(circle.area(3));
	}
}