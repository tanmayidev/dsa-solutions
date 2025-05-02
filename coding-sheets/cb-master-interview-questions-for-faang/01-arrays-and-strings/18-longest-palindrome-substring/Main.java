import java.util.*;
class Main {
public static String preProcess(String str) {
if (str.length() == 0) {
return "^$";

}
String t = "^";
for (int i = 0; i < str.length(); i++) {
t += "#" + str.charAt(i);
}
t += "#$";
return t;
}
public static String longestPalSub(String str) {
String t = preProcess(str);
int n = t.length();
int[] P = new int[n];// array of size n filled with 0
int maxPalCenterID = 1;
for (int i = 1; i < n - 1; i++) {
while (t.charAt(i + 1 + P[i]) == t.charAt(i - 1 - P[i]))
P[i]++;
if (P[i] > P[maxPalCenterID])
maxPalCenterID = i;
}
int maxPalSize = P[maxPalCenterID];
int palStartID = (maxPalCenterID - 1 - maxPalSize) / 2;
return str.substring(palStartID, palStartID + maxPalSize);
}
public static void main (String[] args) {
Scanner s = new Scanner(System.in);
int t = s.nextInt();
while(t-- != 0) {
String str = s.next();
String ans = longestPalSub(str);
System.out.println(ans);
}
}
}