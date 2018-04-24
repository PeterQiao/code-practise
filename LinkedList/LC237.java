/*
237. Delete Node in a Linked List
思路：这题目要求给一个node，要求将这个node从list里删除，但是没有头节点。
所以直接赋值就可以了，将node的val和next替换为下一个节点的。
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        if(node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}