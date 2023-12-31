
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0);
        ListNode sec = new ListNode(0);

        ListNode dS = first;
        ListNode dL = sec;

        while(head != null){
            if(head.val < x){
                dS.next = new ListNode(head.val);
                dS = dS.next;
            }else{
                dL.next = new ListNode(head.val);
                dL = dL.next;
            }
            head = head.next;
        }
        dS.next = sec.next;
        return first.next;
    }
}