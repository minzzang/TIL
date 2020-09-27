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
import java.util.Arrays;
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

        st = new StringTokenizer(br.readLine());
        for (int n=0; n<A; n++) {
            a[n] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int n=0; n<B; n++) {
            b[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int[] result = new int[A+B];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i<A && j<B) {
            if(a[i] > b[j]) {
                result[k++] = b[j++];
            } else {
                result[k++] = a[i++];
            }
        }

        while (i != A) {
            result[k++] = a[i++];
        }

        while (j != B) {
            result[k++] = b[j++];
        }

        for (int n=0; n<result.length; n++) {
            sb.append(result[n] + " ");
        }
        System.out.println(sb);
    }
}