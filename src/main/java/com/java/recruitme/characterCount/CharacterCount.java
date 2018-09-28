package com.java.recruitme.characterCount;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterCount {
	public static Map<Character, Integer> countCharacters(String string) {
		if (null == string)
			return Collections.emptyMap();

		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == ' ') {
				count++;
			}
		}
		
		if(count == string.length())
			return Collections.emptyMap();
		
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String[] arr = string.split(" ");
		for (String string2 : arr) {
			char[] ch = string2.toCharArray();
			for (char c : ch) {
				if (!map.containsKey(c)) {
					map.put(c, 1);
				} else {
					map.put(c, map.get(c) + 1);
				}
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		Map<Character, Integer> characterCount = CharacterCount.countCharacters("Hello hari!!");
		System.out.println(characterCount);
		System.out.println("Anish");
	    
	}
}
