 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-26
  * URL   : https://www.acmicpc.net/problem/14891
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[4][8];

        for (int i=0; i<4; i++) {
            String s = br.readLine();
            for (int j=0; j<8; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            dfs( '-', index, -direction);
            dfs( '+', index, -direction);

            rotation(index, direction);
        }

        int answer = 0;
        if (arr[0][0] == 1) answer += 1;
        if (arr[1][0] == 1) answer += 2;
        if (arr[2][0] == 1) answer += 4;
        if (arr[3][0] == 1) answer += 8;

        System.out.println(answer);
    }

    private static void dfs(char c, int index, int direction) {
        int compareIndex = c == '+' ? index + 1 : index - 1;
        if (compareIndex == 0 || compareIndex == 5) return;

        if (c == '+') {
            if (arr[index-1][2] != arr[compareIndex-1][6]) {
                dfs(c, compareIndex, -direction);
                rotation(compareIndex, direction);
            }
        } else {
            if (arr[index-1][6] != arr[compareIndex-1][2]) {
                dfs(c, compareIndex, -direction);
                rotation(compareIndex, direction);
            }
        }
    }

    private static void rotation(int index, int direction) {
        int tmp = 0;

        if (direction == 1) {
            tmp = arr[index-1][7];
            for (int i=7; i>0; i--) {
                arr[index-1][i] = arr[index-1][i-1];
            }
            arr[index-1][0] = tmp;
        } else {
            tmp = arr[index-1][0];
            for (int i=0; i<7; i++) {
                arr[index-1][i] = arr[index-1][i+1];
            }
            arr[index-1][7] = tmp;
        }
    }

}


