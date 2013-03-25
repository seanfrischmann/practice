package code;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Scramble {
	//Method scrambles characters within a string
	public Scramble(String s){
		getScrambled(s);
	}
	
	public static void main(String[] args) {
		new Scramble("Sean Frischmann");
		
	}
	
	public static String getScrambled(String s){
		String[] scram = s.split("");
		List<String> letters = Arrays.asList(scram);
		Collections.shuffle(letters);
		StringBuilder sb = new StringBuilder(s.length());
		for (String c : letters){
			sb.append(c);
		}
		System.out.print(sb.toString());
		return sb.toString();
	}

}
