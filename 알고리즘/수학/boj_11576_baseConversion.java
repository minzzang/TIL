 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-15
  * URL   : https://www.acmicpc.net/problem/11576
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> result = new Stack<>();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i=length; i>0; i--) {
            int n = Integer.parseInt(st.nextToken());
            sum += Math.pow(A, i-1) * n;
        }

        while (sum != 0) {
            result.push(sum % B);
            sum = sum / B;
        }

        while (!result.empty()) {
            if (result.size() == 1) {
                System.out.print(result.pop());
            } else {
                System.out.print(result.pop() + " ");
            }
        }

    }

}
