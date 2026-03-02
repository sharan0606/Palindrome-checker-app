/**
 * ==============================================================
 * UC13 : Performance Comparison of Palindrome Algorithms
 * ==============================================================
 *
 * Goal:
 * Compare execution time of different palindrome approaches.
 *
 * Concepts Used:
 * - System.nanoTime()
 * - Algorithm comparison
 */

import java.util.*;

public class PalindromeApp {

    // ------------------ Recursive Approach ------------------
    public static boolean recursiveCheck(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursiveCheck(str, start + 1, end - 1);
    }

    // ------------------ Stack Approach ------------------
    public static boolean stackCheck(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // ------------------ Deque Approach ------------------
    public static boolean dequeCheck(String str) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    // ------------------ Main Method ------------------
    public static void main(String[] args) {

        String input = "racecar";

        long start1 = System.nanoTime();
        boolean r1 = recursiveCheck(input, 0, input.length() - 1);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean r2 = stackCheck(input);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean r3 = dequeCheck(input);
        long end3 = System.nanoTime();

        System.out.println("Input : " + input);
        System.out.println("----------------------------------");
        System.out.println("Recursive Result : " + r1);
        System.out.println("Recursive Time   : " + (end1 - start1) + " ns");
        System.out.println("----------------------------------");
        System.out.println("Stack Result     : " + r2);
        System.out.println("Stack Time       : " + (end2 - start2) + " ns");
        System.out.println("----------------------------------");
        System.out.println("Deque Result     : " + r3);
        System.out.println("Deque Time       : " + (end3 - start3) + " ns");
    }
}
