 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-16
  * URL   : https://www.acmicpc.net/problem/10825
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String[][] studentInfo = new String[length][4];

        StringTokenizer st;
        for (int i=0; i<length; i++) {
            st = new StringTokenizer(br.readLine());
            studentInfo[i][0] = st.nextToken();
            studentInfo[i][1] = st.nextToken();
            studentInfo[i][2] = st.nextToken();
            studentInfo[i][3] = st.nextToken();
        }

        Arrays.sort(studentInfo , (o1, o2) -> {
            if (o1[1].equals(o2[1])) {
                if (o1[2].equals(o2[2])) {
                    if (o1[3].equals(o2[3])) {
                        return o1[0].compareTo(o2[0]);
                    }
                    return Integer.compare(Integer.parseInt(o2[3]), Integer.parseInt(o1[3]));
                }
                return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
            }
            return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
        });

        for (String[] s : studentInfo) {
            System.out.println(s[0]);
        }

    }

}