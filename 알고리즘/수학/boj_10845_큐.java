 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-14
  * URL   : https://www.acmicpc.net/problem/10845
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        Deque<Integer> queue = new LinkedList<>();
        for (int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            if ("push".equals(type)) {
                int n = Integer.parseInt(st.nextToken());
                queue.add(n);
            } else if ("pop".equals(type)) {
                sb.append(queue.isEmpty() ? -1 + "\n" : queue.poll() + "\n");
            } else if ("size".equals(type)) {
                sb.append(queue.size() + "\n");
            } else if ("empty".equals(type)) {
                sb.append(queue.isEmpty() ? 1 + "\n" : 0 + "\n");
            } else if ("front".equals(type)) {
                sb.append(queue.isEmpty() ? -1 + "\n" : queue.peek() + "\n");
            } else if ("back".equals(type)) {
                sb.append(queue.isEmpty() ? -1 + "\n" : queue.peekLast() + "\n");
            }
        }

        System.out.println(sb);
    }
}
