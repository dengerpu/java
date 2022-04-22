interface personbuilder{
	person buildperson(String name);
}
class person{
	private String name;
	public person(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}
public class example45{
	public static void printName(String name,personbuilder builder){
		System.out.println(builder.buildperson(name).getName());
	}
	public static void main(String[] args){
		printName("ÕÔÀö",name->new person(name));
		printName("ÕÔÀöÓ±",person::new);
	}
}