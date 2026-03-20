// Using HashSet

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine().toLowerCase();

        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                set.add(c);
            }
        }

        if (set.size() == 26) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

// Without using Hashest
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        br.readLine(); // ignore n
        String s = br.readLine().toLowerCase();

        boolean[] seen = new boolean[26];

        for (char c : s.toCharArray()) {
            seen[c - 'a'] = true;
        }

        for (boolean b : seen) {
            if (!b) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}

// Java One-liner - Stream based

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        br.readLine();
        System.out.println(
            br.readLine().toLowerCase().chars().filter(c -> c >= 'a' && c <= 'z').distinct().count() == 26
            ? "YES" : "NO"
        );
    }
}