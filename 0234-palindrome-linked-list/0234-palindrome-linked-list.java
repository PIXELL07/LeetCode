class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow;
        ListNode prev = null;
        while (mid != null) {
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }
        
        ListNode head1 = head, head2 = prev;
        while (head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
}