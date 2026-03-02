import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/**
 * ==============================================================
 * MAIN CLASS - UseCase6PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 6: Queue + Stack Based Palindrome Checker
 *
 * Description:
 * This class demonstrates FIFO and LIFO behavior
 * using Queue and Stack to validate a palindrome.
 *
 * At this stage, the application:
 * - Enqueues characters into a queue
 * - Pushes characters into a stack
 * - Compares dequeue with pop
 * - Displays the result
 *
 * @author rohidh
 * @version 6.0
 */

public class PalindromeApp {

    /**
     * Application entry point for UC6.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Declare and initialize input string
        String input = "madam";

        // Create Stack (LIFO)
        Stack<Character> stack = new Stack<>();

        // Create Queue (FIFO)
        Queue<Character> queue = new LinkedList<>();

        // Insert characters into both structures
        for (char c : input.toCharArray()) {
            stack.push(c);      // LIFO
            queue.add(c);       // FIFO
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Compare dequeue (FIFO) vs pop (LIFO)
        while (!stack.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}