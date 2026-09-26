package com.practice.meta;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {

    public static void main(String args[]){
        calculate("2+3");
    }

    public static int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int currentNumber = 0;
        char lastOperator = '+'; // Start with a default operator

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // 1. Build the current number
            if (Character.isDigit(currentChar)) {
                // (currentChar - '0') converts char '5' to int 5
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            // 2. Process the number when we hit an operator or the end of the string
            // We ignore whitespace.
            if ((!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)) || i == s.length() - 1) {
                switch (lastOperator) {
                    case '+':
                        stack.push(currentNumber);
                        break;
                    case '-':
                        stack.push(-currentNumber);
                        break;
                    case '*':
                        // Perform multiplication on the last stack element
                        stack.push(stack.pop() * currentNumber);
                        break;
                    case '/':
                        // Java's integer division truncates toward zero automatically
                        stack.push(stack.pop() / currentNumber);
                        break;
                }

                // The current operator will be the 'lastOperator' for the next number
                lastOperator = currentChar;
                currentNumber = 0;
            }
        }

        // 3. Sum all the processed terms in the stack for the final result
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
