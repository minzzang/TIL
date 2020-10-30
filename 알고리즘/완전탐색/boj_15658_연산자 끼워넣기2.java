 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-30
  * URL   : https://www.acmicpc.net/problem/15658
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] oper = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr, oper, 0, arr[0]);
        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int[] arr, int[] oper, int depth, int sum) {
        if (depth == N-1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i=0; i<4; i++) {
            if (oper[i] > 0) {
                oper[i]--;

                switch(i) {
                    case 0 : dfs(arr, oper, depth+1, sum + arr[depth+1]); break;
                    case 1 : dfs(arr, oper, depth+1, sum - arr[depth+1]); break;
                    case 2 : dfs(arr, oper, depth+1, sum * arr[depth+1]); break;
                    case 3 : dfs(arr, oper, depth+1, sum / arr[depth+1]); break;
                }

                oper[i]++;
            }
        }
    }
}