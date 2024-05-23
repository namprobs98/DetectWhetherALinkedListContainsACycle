/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.detectwhetheralinkedlistcontainsacycle;

import java.util.Scanner;

/**
 *
 * @author Nhat Anh
 */

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
    
    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DetectWhetherALinkedListContainsACycle {

    
    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int index = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedListNode head = null;
            SinglyLinkedListNode prev = null;

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                SinglyLinkedListNode node = new SinglyLinkedListNode(item);

                if (i == index) {
                    head = node;
                }

                if (prev != null) {
                    prev.next = node;
                }

                prev = node;
            }

            if (prev != null) {
                prev.next = head; 
            }

            boolean result = hasCycle(head);

            System.out.println(result ? "1" : "0");
        }

        scanner.close();
    }
}
