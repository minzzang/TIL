 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-26
  * URL   : https://www.acmicpc.net/problem/11728
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] a = new int[A];
        int[] b = new int[B];

        Map<Integer, Integer> minusMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num >= 0) {
                map.put(num, 1);
            } else {
                minusMap.put(num, 1);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num >= 0) {
                map.put(num, 1);
            } else {
                minusMap.put(num, 1);
            }
        }

        for (int n : minusMap.keySet()) {
            sb.append(n + " ");
        }

        for (int n : map.keySet()) {
            sb.append(n + " ");
        }
        System.out.println(sb);
    }
}