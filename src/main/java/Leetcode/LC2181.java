package Leetcode;

import java.util.Stack;

class Solution2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode rootNode = new ListNode();
        final ListNode result = rootNode;
        Stack<Integer> s = new Stack<Integer>();
        int sum = 0;

        while (head.next != null) {
            if (head.val != 0) {
                sum += head.val;
            } else {
                if (s.empty()) {
                    s.push(0);
                } else {
                    rootNode.val = sum;
                    if (head.next.next != null) {
                        rootNode.next = new ListNode(0, null);
                        // rootNode = rootNode.next;
                    } else
                        rootNode.next = null;

                    rootNode = rootNode.next;

                    sum = 0;
                }
            }

            head = head.next;
        }

        return result;
    }

    public ListNode toListNode(int[] a) {
        ListNode node = new ListNode();
        final ListNode result = node;

        for (int i : a) {
            node.val = i;
            node.next = new ListNode();

            node = node.next;
        }

        return result;
    }
}

public class LC2181 {
    public static void main(String[] args) {
        ListNode aListNode = new ListNode(4, new ListNode(11));
        Solution2181 solution2181 = new Solution2181();
        int[] a = { 0, 3, 1, 0, 4, 5, 2, 0 };
        int[] b = {0,1,0,3,0,2,2,0};
        int[] c = {0, 1, 2, 3, 4, 0, 5, 6, 7, 0, 8, 9, 0};

        System.out.println(solution2181.mergeNodes(solution2181.toListNode(c)).toString());
    }
}
