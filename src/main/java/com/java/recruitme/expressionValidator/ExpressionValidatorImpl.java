package com.java.recruitme.expressionValidator;

import java.util.Stack;

import com.java.recruitme.services.MethodNotImplementedException;

public class ExpressionValidatorImpl implements ExpressionValidator {

	private static Character L1 = '{';
	private static Character L2 = '[';
	private static Character L3 = '(';

	private static Character R1 = '}';
	private static Character R2 = ']';
	private static Character R3 = ')';

	public boolean isBalancedExpression(String expression) throws MethodNotImplementedException {

		if (expression == null)
			return false;

		return validateExpression(expression);

	}

	private boolean validateExpression(String expression) {

		Stack<Character> characters = new Stack<Character>();
		int count = 0;
		for (int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i) == L1 || expression.charAt(i) == L2 || expression.charAt(i) == L3)
				characters.push(expression.charAt(i));
		}
		/*
		for (int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i)  == L1)
				characters.push(expression.charAt(i));
			
			if(expression.charAt(i)  == L2)
				characters.push(expression.charAt(i));
			if(expression.charAt(i)  == L3)
				characters.push(expression.charAt(i));
			if(expression.charAt(i)  == R3) {
				if(characters.peek() == L3)
					characters.pop();
			}
			if(expression.charAt(i)  == R2) {
				if(characters.peek() == L2)
					characters.pop();
			}
			if(expression.charAt(i)  == R1) {
				if(characters.peek() == L1)
					characters.pop();
			}
		}
		*/
		while (!characters.isEmpty()) {
			int i = ++count;
			if(expression.charAt(i)  == L1)
				characters.push(expression.charAt(i));
			if(expression.charAt(i)  == L2)
				characters.push(expression.charAt(i));
			if(expression.charAt(i)  == L3)
				characters.push(expression.charAt(i));
			if(expression.charAt(i)  == R3) {
				if(characters.peek() == L3)
					characters.pop();
			}
			if(expression.charAt(i)  == R2) {
				if(characters.peek() == L2)
					characters.pop();
			}
			if(expression.charAt(i)  == R1) {
				if(characters.peek() == L1)
					characters.pop();
			}
				
			
		}
		
		return characters.isEmpty() ? true : false;
	}
	
	public static void main(String[] args) {
		System.out.println(new ExpressionValidatorImpl().isBalancedExpression("{{[[(())]]}}"));
	}
}
