 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-17
  * URL   : https://www.acmicpc.net/problem/9613
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int length = 0;
        for (int i=0; i<n; i++) {
            long sum = 0;
            st = new StringTokenizer(br.readLine());
            length = Integer.parseInt(st.nextToken());
            int[] input = new int[length];
            for (int j=0; j<length; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }
            for (int k=0; k<length-1; k++) {
                for (int z=k+1; z<length; z++) {
                    sum += gcd(input[k], input[z]);
                }
            }
            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }

    public static int gcd(int a, int b) {

        if (b == 0) return a;
        return gcd(b, a%b);
    }
}