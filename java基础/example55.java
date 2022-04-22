public class example55{
	public static void main(String[] args){
		String str="2018-01-24";
		System.out.println("从第6个字符截取到末尾的结果:"+str.substring(5));
		System.out.println("从第6个字符截取到第7个字符的结果"+str.substring(5,7));
		System.out.println("分割后的字符串数组中的元素依次为:");
		String[] strArray=str.split("-");//通过横线连“-”将字符串换为字符串数组
		for(int i=0;i<strArray.length;i++){
			if(i!=strArray.length-1)
				System.out.print(strArray[i]+"，");
				else
					System.out.print(strArray[i]);
			
		}
	}
}