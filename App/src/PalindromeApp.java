/**
 * ==============================================================
 * UC11 : Object-Oriented Palindrome Service
 * ==============================================================
 *
 * Goal:
 * Encapsulate palindrome checking logic inside a class
 * following OOPS principles.
 *
 * Concepts Used:
 * - Encapsulation
 * - Single Responsibility Principle
 */

class PalindromeChecker {

    // Encapsulated method to check palindrome
    public boolean checkPalindrome(String input) {

        if (input == null)
            return false;

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}


public class PalindromeApp {

    public static void main(String[] args) {

        String input = "racecar";

        // Create object of PalindromeChecker
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}