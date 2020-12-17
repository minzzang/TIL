 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-17
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12978
  *
  */

import java.util.*;

class Solution {
    private static int INF = 10000000;
    private static boolean[] visited;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = INF;
            }
        }

        for (int[] i : road) {
            int townA = i[0];
            int townB = i[1];
            int dist = i[2];

            map[townA][townB] = Math.min(map[townA][townB], dist);
            map[townB][townA] = Math.min(map[townB][townA], dist);
        }

        Queue<Point> queue = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        for (int i = 2; i <= N; i++) {
            if (map[1][i] == INF) continue;
            queue.offer(new Point(1, i, map[1][i]));
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            visited[p.a] = true;

            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
                if (i == p.b || map[p.b][i] == INF) continue;

                if (map[1][i] > map[p.b][i] + p.dist) {
                    map[1][i] = map[p.b][i] + p.dist;
                    queue.offer(new Point(p.b, i, map[p.b][i] + p.dist));
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (map[1][i] <= K) answer++;
        }

        return answer;
    }

}

class Point {
    int a;
    int b;
    int dist;

    Point(int a, int b, int dist) {
        this.a = a;
        this.b = b;
        this.dist = dist;
    }
}