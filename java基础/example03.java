import java.util.*;
interface Shape {
	public abstract double area(double d);
}
class Square implements Shape {
	 public double area(double d)
	{
		double result=d*d;
		return result;
	}
}
class Circle implements Shape {
	public double area(double d) {
		double result=3.14*d*d;
		return result;
	}
}
public class example03{
	public static void main(String[] args) {
		Shape sq=new Square();
		System.out.println("正方形的面积为："+sq.area(2));
		Shape ci=new Circle();
		System.out.println("圆的面积为："+ci.area(3));
	}
}