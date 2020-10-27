 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-27
  * URL   : https://www.acmicpc.net/problem/14888
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    private static String str = "";
    private static boolean[] visited;
    private static char[] oper = {'+', '-', '*', '/'};
    private static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j=0; j<n; j++) {
                str += oper[i];
            }
        }

        dfs(arr[0], 0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int sum, int depth) {
        if (depth == arr.length-1) {
            min = Math.min(sum, min);
            max = Math.max(sum, max);
        }

        for (int i=0; i<str.length(); i++) {
            if (visited[i]) continue;

            visited[i] = true;
            int cal = calculate(sum, str.charAt(i), arr[depth+1]);
            dfs(cal, depth+1);
            visited[i] = false;
        }
    }

    private static int calculate(int sum, char c, int i) {
        int n = 0;

        if (c == '+') {
            n = sum + i;
        } else if (c == '-') {
            n = sum - i;
        } else if (c == '*') {
            n = sum * i;
        } else {
            n = sum / i;
        }

        return n;
    }

}


