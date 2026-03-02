/**
 * ==============================================================
 * MAIN CLASS - UseCase9PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 9: Recursive Palindrome Checker
 *
 * Description:
 * This class validates whether a string is a palindrome
 * using recursion. The method compares characters from
 * start and end positions and reduces the problem size
 * through recursive calls.
 *
 * @author rohidh
 * @version 9.0
 */

public class UseCase9PalindromeCheckerApp {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // If mismatch found
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String input = "level";

        boolean result = isPalindrome(input, 0, input.length() - 1);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}