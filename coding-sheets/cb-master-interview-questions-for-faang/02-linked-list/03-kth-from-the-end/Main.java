import java.util.*;

public class Main {
  static class ListNode
  {
    int data;
    ListNode next;
  }
  
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head, slow = head;
    
    for(int i=0;i<n;i++)
      fast = fast.next;
    
    if(fast == null) 
      return head.next;
    
    while(fast != null && fast.next != null)
    {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;
    return head;
  }
  public static void main(String args[]) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    
    ListNode head = new ListNode();
    head.data = scn.nextInt();
    ListNode t = head;
    
    for(int i=1;i<n;i++) {
      t.next = new ListNode();
      t.next.data = scn.nextInt();
      t = t.next;
    }

    t.next = null;

    ListNode h = removeNthFromEnd(head,k);
    while(h != null)
    {
      System.out.print(h.data + " ");
      h = h.next;
    }
  }
}