package code;

public class Convert {
	//Method converts String to Integers
	public Convert(String s){
		convert(s);
	}
	public static void main(String[] args) {
		new Convert("Sean Frischmann");
	}
	public String convert(String s){
		char[] input = s.toCharArray();
		String output = "";
		for (char c : input){
			c = Character.toLowerCase(c);
			if ('a'<= c && c <= 'z'){
				output = output +" "+ (c-'a');
			}						
		}
		System.out.print(output);
		return output;
	}

}
