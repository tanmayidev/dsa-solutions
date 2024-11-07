import java.util.*;

class Solution {
  int find(ArrayList<Integer> a, int x) {
  for (int i = 0; i < a.size(); i++)
  if (a.get(i) == x)
  return i;
  return -1;
  }
  void flip(ArrayList<Integer> a, int k) {
  for (int i = 0; i < k / 2; i++) {
  int t = a.get(i);
  a.set(i, a.get(k - i - 1));
  a.set(k - i - 1, t);
  }
  }
  ArrayList<Integer> pancakeSorting(ArrayList<Integer> a) {
  int n = a.size();
  ArrayList<Integer> ans = new ArrayList<Integer>();
  while (n > 0) {
  int i = find(a, n);
  if (i != n - 1) {
  flip(a, i + 1);
  flip(a, n);
  ans.add(i + 1);
  ans.add(n);
  }
  n--;
  }
  return ans;
  }
  }