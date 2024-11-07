import java.util.Scanner;
public class Main {
  public static int shortestDistance(String[] words, String word1, String word2) {
    int a1 = -1;
    int a2 = -1;
    int min = words.length;
    
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        a1 = i;
      } else if (words[i].equals(word2)) {
        a2 = i;
      }
      if (a1 != -1 && a2 != -1) {
        min = Math.min(min, Math.abs(a1 - a2));
      }
    }
    return min;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String [] words = new String[n];
    
    for(int i=0; i<n; i++){
      words[i] = sc.next();
    }

    String word1 = sc.next();
    String word2 = sc.next();
    // for(int i=0; i<n; i++){
    // System.out.print(words[i]+" ");
    // }
    //System.out.println();
    System.out.println(shortestDistance(words,word1,word2));

  }
}