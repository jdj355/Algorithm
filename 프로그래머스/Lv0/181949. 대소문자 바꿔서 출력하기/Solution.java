import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.append(Character.isUpperCase(c)
                    ? Character.toLowerCase(c)
                    : Character.toUpperCase(c));
        }
        System.out.println(sb);
    }
}
