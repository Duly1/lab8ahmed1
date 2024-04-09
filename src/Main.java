class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 100;
        SinglyLinkedList primeList = new SinglyLinkedList();
        SinglyLinkedList primeWithThreeList = new SinglyLinkedList();

        // Populate prime numbers less than n into primeList
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeList.append(i);
            }
        }

        // Move prime numbers containing digit 3 to primeWithThreeList
        Node current = primeList.head;
        while (current != null) {
            if (containsDigitThree(current.data)) {
                primeWithThreeList.append(current.data);
            }
            current = current.next;
        }

        // Find the sum of prime numbers containing digit 3
        int sum = 0;
        current = primeWithThreeList.head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }

        System.out.println("Sum of prime numbers containing digit 3 between 0 and " + n + ": " + sum);
    }

    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Function to check if a number contains digit 3
    public static boolean containsDigitThree(int num) {
        while (num > 0) {
            if (num % 10 == 3) return true;
            num /= 10;
        }
        return false;
    }
}