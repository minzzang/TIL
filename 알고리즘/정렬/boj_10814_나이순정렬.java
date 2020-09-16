 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-16
  * URL   : https://www.acmicpc.net/problem/10814
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String[][] user = new String[length][3];

        for (int i=0; i<length; i++) {
            st = new StringTokenizer(br.readLine());
            user[i][0] = String.valueOf(i+1);
            user[i][1] = st.nextToken();
            user[i][2] = st.nextToken();
        }

        Arrays.sort(user, (o1, o2) -> {
            if (o1[1].equals(o2[1])) {
                return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
            }
            return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
        });

        for (String[] str : user) {
            System.out.println(str[1] + " " + str[2]);
        }

    }
}