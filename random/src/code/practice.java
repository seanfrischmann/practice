package code;

import java.util.HashMap;

public class practice {
	
	public practice(String s){
		phoneBook(s);
	}
	
	
	public HashMap<String, String> phoneBook(String s){
		String input= s ;
		HashMap<String, String> map = new HashMap<String, String>();
		String name="";
		String number="";
		String temp= "";
		for (int i=0; i< input.length(); i++){
			char c = input.charAt(i);
			if(c == ','){
				number = temp;
				temp = "";
				addToMap(map, name, number);
				number=map.get(name);
				System.out.println(name + number);
				
			}
			else if(c == ':'){
				name = temp;
				temp = "";
			}
			else{
				temp = temp + c;
			}
		}
		number = temp;
		addToMap(map, name, number);
		number=map.get(name);
		System.out.println(name + number);
		return map;
	}
	public void addToMap(HashMap<String, String> map, String s, String t){
		if (s !=""){
			if(map.containsKey(s)){
				String value=map.get(s);
				map.put(s, value+" "+t);
				s = "";
			}
			else{
				map.put(s, t);
			}
		}
	}
	public static void main(String[] args){
		practice p = new practice("Sean:2851656,Gabe:6974137,Sean:5916837");
	}

}
