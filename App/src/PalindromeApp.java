public class PalindromeApp {



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

        static boolean isPalindrome(Node head) {
            if (head == null || head.next == null) return true;

            Node slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            Node secondHalf = reverse(slow.next);
            Node firstHalf = head;

            while (secondHalf != null) {
                if (firstHalf.data != secondHalf.data) return false;
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }
            return true;
        }

        public static void main(String[] args) {
            String input = "madam";
            Node head = createLinkedList(input);

            if (isPalindrome(head))
                System.out.println("Palindrome");
            else
                System.out.println("Not a Palindrome");
        }
    }