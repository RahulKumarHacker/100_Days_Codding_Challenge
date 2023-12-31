
public class Solution {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode home = head.next;
        ListNode end = head;

        while (head != null && head.next != null) {
            ListNode aux = head.next; 
            end.next = aux; 
            head.next = aux.next;
            aux.next = head;
            end = head;
            head = head.next; 
        }
        return home;
    }
}