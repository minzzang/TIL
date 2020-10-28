 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-28
  * URL   : https://www.acmicpc.net/problem/14501
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<int[]> list = new ArrayList<>();
    private static int N, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            list.add(arr);
        }

        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int index, int sum) {
        if (index > N-1) {
            max = Math.max(sum, max);
            return;
        }

        for (int i=index; i<N; i++) {
            int[] arr = list.get(i);

            if (i + arr[0] > N) {
                dfs(i + arr[0], sum);
            } else {
                dfs(i + arr[0], sum + arr[1]);
            }
        }
    }
}


