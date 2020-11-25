 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-25
  * URL   : https://www.acmicpc.net/problem/1697
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, K;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[100001];

        bfs(N, 0);
    }

    private static void bfs(int n, int depth) {
        Queue<Dot> queue = new LinkedList<>();
        queue.offer(new Dot(n, depth));

        while (!queue.isEmpty()) {
            Dot dot = queue.poll();
            if (dot.position == K) {
                System.out.println(dot.depth);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int newPosition = dot.position;

                if (i == 0) {
                    newPosition += 1;
                } else if (i == 1) {
                    newPosition -= 1;
                } else {
                    newPosition *= 2;
                }

                if (newPosition >= 0 && newPosition < 100001 && dp[newPosition] == 0) {
                    queue.offer(new Dot(newPosition, dot.depth + 1));
                    dp[newPosition]++;
                }
            }
        }
    }

    static class Dot {
        int position;
        int depth;

        Dot(int position, int depth) {
            this.position = position;
            this.depth = depth;
        }
    }
}
