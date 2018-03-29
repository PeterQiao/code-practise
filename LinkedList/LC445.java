/**
Input: two non-empty linked lists, representing two non-negative integers, the most significant digit comes first and each of their nodes contain a single digit
output: add the two numbers and return it as a linked list
hint: how to add two number and add carry
*/
/**
 * Created by peter on 3/29/2018.
 */
import java.util.*;

public class LC445 {
    class ListNode {
        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode add(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1 == null && l2 == null) {
            return new ListNode(0);
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while(!s2.empty() || !s2.empty()) {
            if(!s1.empty()) sum += s1.pop();
            if(!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }
}