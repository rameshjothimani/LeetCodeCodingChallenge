package com.leetcode.challenge.march22;

import java.util.Stack;
/*
* Valid Parantheses
* https://leetcode.com/problems/valid-parentheses/
* */
public class ValidParantheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();

        /*Stack<Character> stack = new Stack<>();
        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put('(', ')');
        characterMap.put('[', ']');
        characterMap.put('{', '}');

        for (char c : s.toCharArray()) {
            if (characterMap.containsKey(c)) {
                stack.add(c);
            } else if (stack.isEmpty() || c != characterMap.get(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();*/

        /*char[] stack = new char[s.length() + 1];
        char[] charArray = new char[256];

        charArray[')'] = '(';
        charArray['}'] = '{';
        charArray[']'] = '[';

        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                counter++;
                stack[counter] = s.charAt(i);
            } else {
                char a = stack[counter];
                counter--;
                if (counter < 0) {
                    return false;
                }
                if (a != charArray[s.charAt(i)]) {
                    return false;
                }
            }

        }
        return counter == 0;*/

    }

    public static void main(String[] args) {
        ValidParantheses validParantheses = new ValidParantheses();
        String input = "()[]{}";
        if (validParantheses.isValid(input)) {
            System.out.println("The paranthesis is valid");
        } else {
            System.out.println("The paranthesis is invalid");
        }
    }
}
