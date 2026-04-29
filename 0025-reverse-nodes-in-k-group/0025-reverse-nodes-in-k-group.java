class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int total = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            total++;
        }
        if(total < k){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp1 = dummy;
        while(total >= k){
            ListNode temp2 = temp1;
            int l = k;
            while(l > 0){
                temp2 = temp2.next;
                l--;
            }
            ListNode nxtgroup = temp2.next;
            ListNode start = temp1.next;
            temp1.next = reverse(start, nxtgroup);
            temp1 = start;
            total = total - k;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode nxtnode){
        ListNode prev = nxtnode;
        ListNode current = head;
        while(current != nxtnode){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}
