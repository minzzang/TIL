 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-22
  * URL   : https://www.acmicpc.net/problem/2331
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Map<String, Integer> map = new HashMap<>();

    private static List<String> list = new ArrayList<>();

    private static StringBuffer sb = new StringBuffer();

    private static String answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        int P = Integer.parseInt(st.nextToken());

        map.put(A, 1);
        list.add(A);

        dfs(A,P);

        System.out.println(list.indexOf(answer));
    }

    private static void dfs(String A, int P) {

        if (map.get(A) != null && map.get(A) == 2) {
            answer = A;
            return;
        }

        int sum = 0;
        for (int i=0; i<A.length(); i++) {
            sum += Math.pow(A.charAt(i) - '0', P);
        }

        String strSum = String.valueOf(sum);
        if (map.get(strSum) != null) {
            map.put(strSum, 2);
        } else {
            map.put(strSum, 1);
        }
        list.add(strSum);

        dfs(strSum, P);

    }

}


