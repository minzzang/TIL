 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-26
  * URL   : https://www.acmicpc.net/problem/13549
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, K, min = Integer.MAX_VALUE;
    private static boolean[] visited;


    private static class Point {
        int position;
        int time;

        Point(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        bfs();
        System.out.println(min);
    }

    private static void bfs() {
        Deque<Point> deque = new LinkedList<>();
        deque.offer(new Point(N, 0));

        while (!deque.isEmpty()) {
            Point point = deque.poll();
            visited[point.position] = true;

            if (point.position == K) min = Math.min(min, point.time);

            for (int i = 0; i < 3; i++) {
                int newPosition = point.position;

                if (i == 0) {
                    newPosition *= 2;
                } else if (i == 1) {
                    newPosition -= 1;
                } else {
                    newPosition += 1;
                }

                if (newPosition < 0 || newPosition > 100000) continue;
                if (visited[newPosition]) continue;

                if (i == 0) deque.addFirst(new Point(newPosition, point.time));
                else deque.addLast(new Point(newPosition, point.time + 1));
            }
        }
    }

}