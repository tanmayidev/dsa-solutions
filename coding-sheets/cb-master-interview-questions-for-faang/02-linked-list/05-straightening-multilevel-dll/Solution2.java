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


class Solution {
  Node ans;
  Node curr;
  
  public Node flatten(Node head) {
    ans = new Node(-1);
    curr = ans;
    
    helper(head);
    return ans.next;
  }
  
  private void helper(Node node) {
    if (node == null) {
      return;
    }
    Node prev = curr;
    curr.next = new Node(node.val);
    curr = curr.next;

    curr.prev = prev.val == -1 ? null : prev;
    
    if (node.child != null) {
      helper(node.child);
    }
    helper(node.next);
  }
}