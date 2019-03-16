/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (32.05%)
 * Total Accepted:    170.2K
 * Total Submissions: 527.5K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
 * 
 * 
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
    public ListNode deleteDuplicates(ListNode head) {
       if(head == null || head.next == null) return head;
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode fast = head;
       ListNode slow = dummy;
       while(fast != null) {
           while(fast.next != null && fast.val == fast.next.val) {
               fast = fast.next;
           }
           if(slow.next != fast) {
               slow.next = fast.next;
               fast = slow.next;
           } else {
               slow = slow.next;
               fast = fast.next;
           }
       }
       return dummy.next; 
    }
}

