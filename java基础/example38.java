interface Animal{
	void shout();
}
public class example38{
	public static void main(String[] args){
		String name="Π‘»¨";
		animalshout(new Animal(){
			public void shout(){
				System.out.println(name+"ίχίχίχ***");
			}
		});
	}
	public static void animalshout(Animal an){
		an.shout();
	}
}