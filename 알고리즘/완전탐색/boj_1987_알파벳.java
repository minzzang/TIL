 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-01-24	
  * URL   : https://www.acmicpc.net/problem/1987
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int R, C, MAX;
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
    static char[][] board;
    static Map<Character, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0 ; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        map = new HashMap<>();
        map.put(board[0][0], 1);
        dfs(0, 0, 1);

        System.out.println(MAX);
    }

    private static void dfs(int x, int y, int depth) {
        MAX = Math.max(MAX, depth);

        for (int i = 0; i < 4; i++) {
            int newX = dx[i] + x;
            int newY = dy[i] + y;

            if (newX < 0 || newX >= C || newY < 0 || newY >= R) continue;
            if (map.containsKey(board[newY][newX])) continue;

            map.put(board[newY][newX], 1);
            dfs(newX, newY, depth+1);
            map.remove(board[newY][newX]);
        }
    }

}

