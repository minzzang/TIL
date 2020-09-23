 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-23
  * URL   : https://www.acmicpc.net/problem/10816
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] check = new int[20000001];
        for (int i=0; i<N; i++) {
            int input = Integer.parseInt(st.nextToken());
            check[input + 10000000]++;
        }

        int M = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (check[target + 10000000] != 0) {
                sb.append(check[target + 10000000] + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);

    }
}