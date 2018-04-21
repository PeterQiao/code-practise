/*
Insertion Sort List
思路：利用dummy保存原list的head， 每次在排序后的list找到下一个node的插入位置
理解22-25行： 目的是把cur插入到pre之后
            ListNode temp = cur.next; //保存当前cur的下一个node 
            cur.next = pre.next; // 插入cur到pre之后，所以cur的next要指向原先pre的next
            pre.next = cur; // 插入cur到pre之后
            cur = temp; // 处理下一个未排序list中的节点，就是原先的cur.next
*/

public class LC147 {
    
    public ListNode solution(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);

        ListNode cur = head;

        while(cur != null) {
            ListNode pre = dummy;
            // 在排序过的list中找到插入位置，就是cur.val >= pre.next.val
            while(pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            ListNode temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
        }

        return dummy.next;
    }

}