 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-21
  * URL   : https://www.acmicpc.net/problem/1991
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static char[][] arr;

    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][3];

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char index = st.nextToken().charAt(0);
            arr[index-65][0] = index;
            arr[index-65][1] = st.nextToken().charAt(0);
            arr[index-65][2] = st.nextToken().charAt(0);
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        System.out.println(sb);

    }

    private static void preOrder(int c) {
        if ((char)(c+65) == '.') return;
        sb.append(arr[c][0]);
        preOrder(arr[c][1] - 65);
        preOrder(arr[c][2] - 65);
    }

    private static void inOrder(int c) {
        if ((char)(c+65) == '.') return;

        inOrder(arr[c][1] - 65);
        sb.append(arr[c][0]);
        inOrder(arr[c][2] - 65);
    }

    private static void postOrder(int c) {
        if ((char)(c+65) == '.') return;

        postOrder(arr[c][1] - 65);
        postOrder(arr[c][2] - 65);
        sb.append(arr[c][0]);
    }


}


