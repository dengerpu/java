public class example74{
	public static void main(String[] args){
		String str="HelloWord";
		char[] ch=str.toCharArray();
		int i;
		for(i=0;i<str.length();i++){
			if(ch[i]>='A'&&ch[i]<='Z')
				ch[i].toLowerCase();
			else if(ch[i]>='a'&&ch[i]<='z')
				ch[i].toUpperCase();
		}
		StringBuffer sb=new StringBuffer();
		for(i=str.length()-1;i>0;i--){
			sb.append(str.charAt(i));
		}
		System.out.printfln(sb.toString());
	}
}