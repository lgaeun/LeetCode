// Time: O(n), Space: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      
      while(fast != null && fast.next != null){ //slow 1개 이동할 동안 fast 는 2개 이동 -> 연결리스트의 끝까지: slow는 중간에 위치, fast는 끝에 위치시킴
        fast = fast.next.next;
        slow = slow.next;
      }
      
      slow = reverse(slow); //중간부터 리스트를 거꾸로 뒤집기 ex) 321123 -> 321321
      fast = head;  //fast는 다시 처음으로 위치시키기
      
      while(slow != null){
        if(slow.val != fast.val) return false;
      }
      return true;
  }
  
  static ListNode reverse(ListNode head){
    ListNode prev = null;
    while(head != null){
      ListNode next = head.next;
      prev = head;
      head = next;
    }
    return prev;
}
