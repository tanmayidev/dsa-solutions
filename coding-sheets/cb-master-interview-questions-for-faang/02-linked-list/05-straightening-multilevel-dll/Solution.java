import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class ListNode {
  public Integer val;
  public ListNode prev;
  public ListNode next;
  public ListNode child;


  public ListNode() {}


  public ListNode(Integer val) {
    this.val = val;
  }


  public ListNode(Integer val , ListNode prev ,ListNode next, ListNode child) {
    this.val = val;
    this.prev = prev;
    this.next = next;
    this.child = child;
  }
}

class Solution {
  public ListNode flatten(ListNode head) {
    
    if(head == null) {
      return null;
    }

    ListNode pseudoHead = new ListNode(0,null,head,null);
    Stack<ListNode> stack = new Stack<>();
    ListNode curr , prev = pseudoHead;
    
    stack.push(head);
    
    while (!stack.isEmpty()) {
      curr = stack.pop();
      prev.next = curr;

      curr.prev = prev;
    
      if (curr.next != null) {
        stack.push(curr.next);
      }

      if (curr.child != null) {
        stack.push(curr.child);
        curr.child = null;
      }
      prev = curr;
    }
    pseudoHead.next.prev = null;
    return pseudoHead.next;
  }
}

class Main {

  public static Integer[] stringToIntegerArray(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    
    if (input.length() == 0) {
      return new Integer[0];
    }
    
    String[] parts = input.split(",");
    Integer[] output = new Integer[parts.length];
    for(int index = 0; index < parts.length; index++) {
      String part = parts[index].trim();

      if (!part.equals("null")) {
        output[index] = Integer.parseInt(part);
      } else {
        output[index] = null;
      }
    }
    return output;
  }

  public static ListNode stringToListNode(String input) {
    // Generate array from the input
    Integer[] nodeValues = stringToIntegerArray(input);
    // Now convert that list into linked list
    ListNode dummyRoot = new ListNode(0);
    ListNode ptr = dummyRoot;
    ListNode start = dummyRoot;
    boolean flag = true;
    int count = 0;
    
    for(Integer item : nodeValues) {
      if(item==null) {
        count++;
        continue;
      } 
      else if(count>0) {
        if(flag) {
          flag = false;
        } else {
          count--;
        }

        while(count>0) {
          start = start.next;
          count--;
        }
        start.child= new ListNode(item,null,null,null);
        start = start.child;
        ptr = start;
      }
      else {
        ptr.next = new ListNode(item,ptr,null,null);
        ptr = ptr.next;
      }
    }
    return dummyRoot.next;
  }


  public static String listNodeToString(ListNode node) {
    if (node == null) {
      return "[]";
    }
    
    String result = "";
    while (node != null) {
      result += node.val + ", ";
      node = node.next;
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }

  
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line = in.readLine();
     
    if(line!=null) {
      ListNode head = stringToListNode(line);
      ListNode ret = new Solution().flatten(head);
      String out = listNodeToString(ret);
      System.out.println(out);
    }
  }
}