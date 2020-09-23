 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-23
  * URL   : https://www.acmicpc.net/problem/9366
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] arr;

    private static boolean[] visited;

    private static boolean[] isDone;

    private static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            visited = new boolean[n+1];
            isDone = new boolean[n+1];
            count = 0;

            arr  = new int[n+1];
            for (int i=1; i<=n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i=1; i<=n; i++) {
                if (isDone[i]) continue;
                dfs(i);
            }
            System.out.println(n-count);
        }


    }

    private static void dfs(int num) {

        if (visited[num]) {
            if (isDone[num]) return;

            count += checkCycle(num);
            return;
        }

        visited[num] = true;
        dfs(arr[num]);
        isDone[num] = true;
    }

    private static int checkCycle(int num) {
        int cnt = 0;
        int tmp = num;
        while(num != arr[tmp]) {
            tmp = arr[tmp];
            cnt++;
        }
        return cnt + 1;
    }

}