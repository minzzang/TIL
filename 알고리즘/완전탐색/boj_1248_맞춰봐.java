 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-01-24	
  * URL   : https://www.acmicpc.net/problem/1248
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] visited;
    static boolean flag;
    static char[][] charset;
    static int[] answer;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        charset = new char[n+1][n+1];
        String s = br.readLine();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                charset[i][j] = s.charAt(index++);
            }
        }

        visited = new boolean[21];
        answer = new int[n+1];
        dfs(1);

        for (int i = 1; i <= n; i++) {
            System.out.print(answer[i] + " ");
        }

    }

    private static void dfs(int index) {
        if (index == n + 1 || flag) {
            flag = true;
            return;
        }

        for (int i = 0; i <= 20; i++) {
            if (isAble(i, index) && !flag) {
                answer[index] = i - 10;
                dfs(index + 1);
            }
        }
    }

    private static boolean isAble(int n, int index) {
        for (int i = 1; i <= index; i++) {
            char ch = charset[i][index];
            if (ch == ' ') continue;
            int sum = getSumOf(i, index);

            if (ch == '+' && sum + n - 10 <= 0) return false;
            if (ch == '-' && sum + n - 10 >= 0) return false;
            if (ch == '0' && sum + n - 10 != 0) return false;
        }
        return true;
    }

    private static int getSumOf(int a, int b) {
        int sum = 0;
        for (int i = a; i < b; i++) {
            sum += answer[i];
        }
        return sum;
    }
}
