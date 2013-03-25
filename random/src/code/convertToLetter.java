package code;

public class convertToLetter {
	
	public static void main(String[] args) {
		new convertToLetter("65 82 99");
	}
	
	public convertToLetter(String s){
		convert(s);
	}
	/*
	 * ab cd ef
	 * 1 2 27 3 4 27 5 6
	 */
	public String convert(String s){
		String output = "";
		String x = "";
		for(int i=0; i< s.length(); i++){
			char c = s.charAt(i);
			if (c == ' '){
				int d = Integer.parseInt(x);
				output = output + (Character.toString((char) d)) + " ";
				x = "";
			}
			else{
				x = x + c;
			}
			}
		int d = Integer.parseInt(x);
		output = output + (Character.toString((char) d));		
		System.out.println(x);
		System.out.println(output);
		return output;
	}

}
