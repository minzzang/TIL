 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-16
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/67259
  *
  */

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private static int[] dx = {1,0,0,-1}, dy = {0,1,-1,0};
    private static int N;
    
	
    public static int solution(int[][] board) {
        N = board.length;
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < board.length; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        map[0][0] = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0,-1, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = dx[i] + p.x;
                int newY = dy[i] + p.y;

                if (newX < 0 || newX >= board.length || newY < 0 || newY >= board.length) continue;
                if (board[newY][newX] == 1) continue;

                int moveCost = 0;
                if (p.direction == i || p.direction == -1) {
                    moveCost = p.dist + 100;
                } else { 
                    moveCost = p.dist + 600;
                }

                if (map[newY][newX] >= moveCost) {
                    queue.offer(new Point(newX, newY, i, moveCost));
                    map[newY][newX] = moveCost;
                }
            }
        }
        return map[N-1][N-1];
    }
}

class Point {
    int x;
    int y;
    int direction;
    int dist;

    Point(int x, int y, int direction, int dist) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.dist = dist;
    }
}