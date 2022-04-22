/*
抽象方法：就是加上abstract关键词，然后去掉大括，直接分号结束
抽象类：抽象方法所在的类，必须是抽象类才行。在class之前写上abstract即可

如何使用抽象类和抽象方法：
1.不能直接创建new对象类
2.必须用一个子类来继承抽象父类
3.子类必须覆盖抽象父亲当中的所有的抽象方法
4.创建子类对象进行使用
*/

abstract class Animal{
	public abstract void eat();
}
class Cat extends Animal{
	public void eat(){
		System.out.println("猫吃鱼");
	}
}
public class example30{
	public static void main(String[] args){
		Cat cat=new Cat();
		cat.eat();
	}
}