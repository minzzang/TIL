 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-28
  * URL   : https://www.acmicpc.net/problem/1759
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int L, C, vowel, consonant;
    private static char[] alpha;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alpha);

        search(0, 0);
    }

    private static void search(int index, int depth) {
        if (depth == L) {
            if (vowel >= 1 && consonant >= 2) {
                System.out.println(sb);
            }
            return;
        }

        for (int i=index; i<C; i++) {
            char c = alpha[i];
            sb.append(c);
            if (check(c)) vowel++;
            else consonant++;

            search(i+1, depth+1);
            sb.deleteCharAt(sb.length()-1);

            if (check(c)) vowel--;
            else consonant--;
        }
    }

    private static boolean check(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}


