package codechef;

/**
 * 
 * Rick is a fan of logic-based games. However, he Is bored of the class ones, 
 * like Sudoku and Mastermind, since he has solved so many of them. Recently 
 * he found a new game in which one is given a string with some question marks 
 * in it. The objective g to replace all of the question marks with letters 
 * (one letter per question mark) in such way that no letter appears next to 
 * another letter of the same kind. 
 * 
 * Write a function: 
 * 
 * class Solution { public String solution (String riddle); } 
 * 
 * that, given a string riddle, returns a copy of the string with all of the 
 * question marks replaced by lowercase letters (a-z) in such a way that the 
 * same letters do not occur next to each other. The result can be any of the 
 * possible answers as long as it fulfils the above requirements. 
 * 
 * Examples: 1. Given riddle = "ab?ac?", your function might return "abcaca". 
 *              Some other possible results are "abzacd", "abfacf". 
 *           2. Given riddle = "rd?e?wg??", your function might return "rdveawgab".
 *           3. Given riddle = "????????", your function might return "codility". 
 *           
 * Write an efficient algorithm for the following assumptions: 
 *           1. The length of the string is within the range [1..100,000]; 
 *           2. String riddle consists only of lowercases letters (a - z) or '?' 
 *           3. It is always possible to turn string 'riddle' into a string without 
 *           two identical consecutive letters.
 * 
 */

public class CodilityAdjacentString {

	public static void main(String[] args) {
		System.out.println(solution(" "));
		System.out.println((char) ('z' + 1));
		System.out.println(solution("ab?ac?"));
		System.out.println(solution("rd?e?wg??"));
		System.out.println(solution("y?z"));

	}

	public static String solution(String str) {

		// base case
		if (str == null || str.length() < 0 || str.trim().isEmpty())
			return str;

		String riddle = str.strip();
		char[] charArr = new char[riddle.length()];
		int index = 1;
		char initialChar = 'a';

		if (riddle.charAt(0) == '?')
			charArr[0] = 'a';
		else
			charArr[0] = riddle.charAt(0);

		for (index = 1; index < riddle.length() - 1; index++) {

			char currentChar = riddle.charAt(index);

			if (riddle.charAt(0) == '?' && index == 1) {
				if (charArr[0] == currentChar) {
					charArr[0] = (char) (initialChar + 1);
				}
			}
			
			if (currentChar == '?') {
				initialChar = 'a';
				if (initialChar == charArr[index - 1]) {
					initialChar = (char) (initialChar + 1);
				}
				if (initialChar == riddle.charAt(index + 1)) {
					initialChar = (char) (initialChar + 1);
				}
				if (initialChar == charArr[index - 1]) {
					initialChar = (char) (initialChar + 1);
				}
				charArr[index] = initialChar;
			} else {
				charArr[index] = currentChar;
			}
		}

		// for the last character
		if (riddle.charAt(index) == '?') {
			initialChar = 'a';
			if (charArr[riddle.length() - 2] == initialChar) {
				initialChar = (char) (initialChar + 1);
			}
			charArr[index] = initialChar;
		} else {
			charArr[index] = riddle.charAt(index);
		}

		return String.valueOf(charArr);
	}

}
