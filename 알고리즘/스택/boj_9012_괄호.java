 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-08-12
  * URL   : https://www.acmicpc.net/problem/9012
  *
  */

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i=0; i<N; i++) {

            String s = sc.next();

            if (isVPS(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    private static boolean isVPS(String s) {

        int left = 0;
        int right = 0;

        if (s.charAt(0) == ')') return false;

        if (s.length() % 2 == 1) return false;

        for (int i=0; i<s.length(); i++) {

            if (left < right) return false;

            if (s.charAt(i) == '(') {
                left++;
                continue;
            }
            right++;
        }

        return left == right;

    }
}