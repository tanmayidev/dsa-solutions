import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Set<Character> set = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                set.add(ch);
            }
        }

        System.out.println(set.size());
    }
}