/**
 * ==============================================================
 * UC12 : Strategy Pattern for Palindrome Algorithms
 * ==============================================================
 *
 * Goal:
 * Choose palindrome algorithm dynamically at runtime.
 *
 * Concepts Used:
 * - Interface
 * - Polymorphism
 * - Strategy Pattern
 */

import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Stack Based Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque Based Strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {

        Deque<Character> deque = new LinkedList<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

// Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.checkPalindrome(input);
    }
}

// Main Application
public class PalindromeApp {

    public static void main(String[] args) {

        String input = "level";

        PalindromeContext context = new PalindromeContext();

        // Choose Stack Strategy
        context.setStrategy(new StackStrategy());
        System.out.println("Using Stack Strategy: " +
                context.executeStrategy(input));

        // Switch to Deque Strategy
        context.setStrategy(new DequeStrategy());
        System.out.println("Using Deque Strategy: " +
                context.executeStrategy(input));
    }
}