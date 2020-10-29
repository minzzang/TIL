 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-29
  * URL   : https://www.acmicpc.net/problem/1261
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] arr = new int[Y+1][X+1];
        int[][] dist = new int[Y+1][X+1];
        for (int i=1; i<=Y; i++) {
            String str = br.readLine();
            for (int j=1; j<=X; j++) {
                arr[i][j] = str.charAt(j-1) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            return o1.minValue - o2.minValue;
        });
        queue.offer(new Node(1, 1, 0));
        dist[1][1] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i=0; i<4; i++) {
                int newX = node.x + dx[i];
                int newY = node.y + dy[i];

                if (newX < 1 || newX > X || newY < 1 || newY > Y) continue;

                if (arr[newY][newX] + node.minValue < dist[newY][newX]) {
                    dist[newY][newX] = arr[newY][newX] + node.minValue;

                    queue.offer(new Node(newX, newY, dist[newY][newX]));
                }
            }
        }

        System.out.println(dist[Y][X]);
    }
}

class Node {
    int x;
    int y;
    int minValue;

    Node(int x, int y, int minValue) {
        this.x = x;
        this.y = y;
        this.minValue = minValue;
    }
}