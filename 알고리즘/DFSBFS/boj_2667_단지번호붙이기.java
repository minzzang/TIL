 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-22
  * URL   : https://www.acmicpc.net/problem/2667
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] arr;

    private static StringBuffer sb = new StringBuffer();

    private static int N, cnt;

    private static int[] dx = {-1, 1, 0, 0};

    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 1) {
                    dfs(i, j);
                    list.add(cnt);
                    cnt = 0;
                    count++;
                }
            }
        }
        sb.append(count + "\n");
        Collections.sort(list);
        for (int i : list) {
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int y, int x) {
        arr[y][x] = 0;
        cnt++;

        for (int i=0; i<4; i++) {
            int colX = x + dx[i];
            int colY = y + dy[i];

            if (colX < 0 || colX >= N || colY < 0 || colY >= N || arr[colY][colX] == 0) continue;
            dfs(colY, colX);
        }
    }

}


