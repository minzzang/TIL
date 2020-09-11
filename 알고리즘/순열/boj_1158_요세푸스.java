 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-11
  * URL   : https://www.acmicpc.net/problem/1158
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str, " ");
        StringBuilder sb = new StringBuilder("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            list.add(i+1);
        }

        int index = 0;
        while (!list.isEmpty()) {
            index = (index+K-1) % list.size();
            if (list.size() > 1 ) {
                sb.append(list.remove(index)+", ");
            } else {
                sb.append(list.remove(index)+">");
            }
        }
        System.out.println(sb);
    }

}