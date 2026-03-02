public class PalindromeApp {

    // ================= UC9 : Recursive Palindrome =================

    public static boolean isPalindromeRecursive(String str, int start, int end) {

        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return isPalindromeRecursive(str, start + 1, end - 1);
    }


    // ================= UC8 : Linked List Palindrome =================

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node createLinkedList(String str) {
        Node head = null, tail = null;

        for (int i = 0; i < str.length(); i++) {
            Node newNode = new Node(str.charAt(i));

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    static Node reverse(Node head) {
        Node prev = null, curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static boolean isPalindromeLinkedList(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow.next);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }


    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        String input = "madam";

        // Recursive Check
        boolean recursiveResult =
                isPalindromeRecursive(input, 0, input.length() - 1);

        System.out.println("Recursive Result : " + recursiveResult);

        // Linked List Check
        Node head = createLinkedList(input);
        boolean linkedListResult = isPalindromeLinkedList(head);

        System.out.println("LinkedList Result : " + linkedListResult);
    }
}