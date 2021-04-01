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
        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            list.add(head.val);
            if(head.next == null) break;
            head = head.next;
        }
        
        int n = list.size()-1;
        for(int i = 0; i < list.size()/2; i++){
            if(list.get(i) != list.get(n-i)) return false;
        }
        return true;
    }
}
