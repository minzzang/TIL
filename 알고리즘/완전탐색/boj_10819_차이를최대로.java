 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-09
  * URL   : https://www.acmicpc.net/problem/10819
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer> list = new ArrayList<>();
    private static boolean[] visited;
    private static int[] arr;
    private static int N, sum, prev, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recursion( 0);
        System.out.println(max);
    }

    private static void recursion(int length) {
        if (length == N) {
            int sum = 0;
            for (int i=1; i<list.size(); i++) {
                sum += Math.abs(list.get(i) - list.get(i-1));
            }
            max = Math.max(sum, max);
            return;
        }

        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                recursion(length+1);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}

