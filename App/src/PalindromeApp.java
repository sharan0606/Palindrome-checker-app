import java.util.Deque;
import java.util.LinkedList;

/**
 * ==============================================================
 * MAIN CLASS - UseCase7PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 7: Deque-Based Optimized Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using a Deque
 * (Double Ended Queue) which allows insertion and
 * deletion from both front and rear.
 *
 * At this stage, the application:
 * - Inserts characters into deque
 * - Removes first and last elements
 * - Compares them until deque is empty
 * - Displays the result
 *
 * @author rohidh
 * @version 7.0
 */

public class PalindromeApp {

    /**
     * Application entry point for UC7.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Declare and initialize input string
        String input = "racecar";

        // Create Deque
        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Compare front and rear elements
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}