import java.util.Stack;

/**
 * ==============================================================
 * MAIN CLASS - UseCase5PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 5: Stack Based Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using a Stack
 * data structure which follows the LIFO principle.
 *
 * At this stage, the application:
 * - Pushes characters into a stack
 * - Pops them in reverse order
 * - Compares with original sequence
 * - Displays the result
 *
 * @author rohidh
 * @version 5.0
 */

public class PalindromeApp {

    /**
     * Application entry point for UC5.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Declare and initialize input string
        String input = "noon";

        // Create Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character into stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Compare original string with reversed order (stack pop)
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}