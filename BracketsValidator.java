package my.java.utilities;

import java.io.*;
import java.util.*;

// input	: [{(2+2)*3}+{3*3}]/8 ---> valid
// 		: [{()}] ---> valid
//		: [(] ---> invalid
//		: 3+3 ---> valid
public class BracketsValidator {
	
	public static void main(String args[]) {
		
	String str = args[0];
	
	boolean isValid = validate(str);
	
	if(isValid)
		System.out.println("Valid combination of parantheses");
	else
		System.out.println("Invalid combination of parantheses");
		
	}
	
	public static boolean validate(String str) {
        boolean result = true;
        Stack<Character> stack = new Stack<Character>();
        char currChar, prevChar;
        
        for(int i = 0; i < str.length(); i++) {
            currChar = str.charAt(i);
            if(currChar == '(' || currChar == '[' || currChar == '{') {
                stack.push(currChar);
            } else if(currChar == ')' || currChar == ']' || currChar == '}') {
                if(stack.isEmpty()) {
                    result = false;
                } else {
                    prevChar = stack.peek();
                    if((currChar == ')' && prevChar == '(') || (currChar == ']' && prevChar == '[') || (currChar == '}' && prevChar == '{')) {
                        stack.pop();
                    } else {
                        result = false;
                    }
                }
            }
        }
        if(!stack.isEmpty()) {
            result = false;
        }
        return result;
    }

}
