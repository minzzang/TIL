 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-05
  * URL   : https://www.acmicpc.net/problem/3055
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static boolean[][] visited;
    private static boolean[][] sVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();
        char[][] ch = new char[R][C];
        visited = new boolean[R][C];
        sVisited= new boolean[R][C];

        for (int i=0; i<R; i++) {
            String str = br.readLine();
            for (int j=0; j<C; j++) {
                ch[i][j] = str.charAt(j);
                if (ch[i][j] == 'S') queue.offer(new Node(i, j, 0));
            }
        }

        int dCol = 0, dRow = 0;
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (ch[i][j] == '*') queue.offer(new Node(i, j, 0));
                if (ch[i][j] == 'D') {
                    dCol = j;
                    dRow = i;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if (ch[n.y][n.x] == '*') {
                visited[n.y][n.x] = true;
            } else {
                sVisited[n.y][n.x] = true;
            }

            for (int i=0; i<4; i++) {
                int newX = n.x + dx[i];
                int newY = n.y + dy[i];

                if (newX < 0 || newX >= C || newY < 0 || newY >= R) continue;
                if (ch[newY][newX] == 'X') continue;

                if (ch[n.y][n.x] == '*') {
                    if (visited[newY][newX] || ch[newY][newX] == '*' || ch[newY][newX] == 'D') continue;
                    visited[newY][newX] = true;
                    ch[newY][newX] = '*';
                } else {
                    if (sVisited[newY][newX] || ch[newY][newX] == '*') continue;
                    if (newY == dRow && newX == dCol) {
                        System.out.println(n.depth+1);
                        return;
                    }
                    sVisited[newY][newX] = true;
                    ch[newY][newX] = 'S';
                    ch[n.y][n.x] = '.';
                }
                queue.offer(new Node(newY, newX, n.depth + 1));
            }
        }

        System.out.println("KAKTUS");
    }
}

class Node {
    int x;
    int y;
    int depth;

    Node(int y, int x, int depth) {
        this.y = y;
        this.x = x;
        this.depth = depth;
    }
}