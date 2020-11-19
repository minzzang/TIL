 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-19
  * URL   : https://www.acmicpc.net/problem/4485
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[][] arr;
    private static int[][] dp;
    private static int T;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        while (true) {
            T = Integer.parseInt(br.readLine());
            if (T == 0) break;

            init();
            dijkstra();
            System.out.println("Problem " + (count++) + ": " + dp[T-1][T-1]);
        }
    }

    private static void init() throws IOException {
        arr = new int[T][T];
        dp = new int[T][T];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < T; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] n : dp) {
            Arrays.fill(n, Integer.MAX_VALUE);
        }
        dp[0][0] = arr[0][0];
    }

    private static void dijkstra() {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node newNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newY = newNode.u + dy[i];
                int newX = newNode.v + dx[i];

                if (newY < 0 || newY >= T || newX < 0 || newX >= T) continue;

                if (dp[newY][newX] > dp[newNode.u][newNode.v] + arr[newY][newX]) {
                    dp[newY][newX] = dp[newNode.u][newNode.v] + arr[newY][newX];
                    queue.offer(new Node(newY, newX));
                }
            }
        }
    }

}

class Node {
    int u;
    int v;

    Node (int u, int v) {
        this.u = u;
        this.v = v;
    }
}