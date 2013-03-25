package code;

public class EveryOther {
	
	public EveryOther(String s){
		everyOther(s);
	}
	public String everyOther(String s){
		String other="";
		for(int i=0;i<s.length();i=i+2){
			other=other+s.charAt(i);
		}
		for(int i=1;i<s.length();i=i+2){
			other=s.charAt(i)+other;
		}
		System.out.print(other);
		return other;
	}
	
	public static void main(String[] args) {
		EveryOther c = new EveryOther("seanfrischmann");
	}

}
