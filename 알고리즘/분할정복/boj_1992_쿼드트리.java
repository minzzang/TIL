 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-24
  * URL   : https://www.acmicpc.net/problem/1992
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] arr;
    private static int[] count;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();
            
            for (int j=0; j<N; j++) {
                arr[i][j] = ch[j] - '0';
            }
        }
        
        divide(0, 0, N);
        System.out.println(sb);
    }

    private static void divide(int y, int x, int size) {
        if (isSameNum(y, x, size)) {
            sb.append(arr[y][x]);
        } else {
            int newSize = size / 2;
            sb.append("(");

            for (int i=y; i<y+size; i+=newSize) {
                for (int j=x; j<x+size; j+=newSize) {
                    divide(i, j, newSize);
                }
            }
            sb.append(")");
        }
    }

    private static boolean isSameNum(int y, int x, int size) {
        int num = arr[y][x];

        for (int i=y; i<y+size; i++) {
            for (int j=x; j<x+size; j++) {
                if (arr[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}


