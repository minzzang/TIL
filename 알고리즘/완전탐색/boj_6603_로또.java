 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-27
  * URL   : https://www.acmicpc.net/problem/6603
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int K;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) break;

            int[] arr = new int[K];
            for (int i=0; i<K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(arr, 0, 0);
            System.out.println();
        }
    }

    private static void dfs(int[] arr, int index, int depth) {
        if (depth == 6) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i=index; i<K; i++) {
            list.add(arr[i]);
            dfs(arr, i+1, depth+1);
            list.remove(list.size()-1);
        }
    }
}


