 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-22
  * URL   : https://www.acmicpc.net/problem/2178
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] arr;

    private static int[] dx = {1, -1, 0, 0};

    private static int[] dy = {0, 0, 1, -1};

    private static int N, M, minCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];

        for (int i=1; i<=N; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();
            for (int j=1; j<=M; j++) {
                arr[i][j] = ch[j-1] - '0';
            }
        }
        bfs();
        System.out.println(minCount);
    }

    private static void bfs() {
        Queue<Dot> queue = new LinkedList<>();
        queue.offer(new Dot(1, 1, 1));

        while(!queue.isEmpty()) {
            Dot dot = queue.poll();
            if (dot.y == N && dot.x == M) {
                minCount = dot.step;
                break;
            }

            for (int i=0; i<4; i++) {
                int colX = dot.x + dx[i];
                int colY = dot.y + dy[i];

                if (colX < 0 || colX > M || colY < 0 || colY > N || arr[colY][colX] == 0) continue;
                queue.offer(new Dot(colX, colY, dot.step + 1));
                arr[colY][colX] = 0;
            }
        }
    }
}

class Dot {
    int x;
    int y;
    int step;

    Dot(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}


