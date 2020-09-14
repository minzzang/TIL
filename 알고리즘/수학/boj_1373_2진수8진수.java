 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-14
  * URL   : https://www.acmicpc.net/problem/1373
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int remainder = str.length() % 3;

        if (remainder == 1) {
            sb.append(str.charAt(0));
        } else if (remainder == 2) {
            sb.append((str.charAt(0)-'0') * 2 + (str.charAt(1) - '0'));
        }

        for (int i=remainder; i<str.length(); i+=3) {
            int sum = (str.charAt(i)-'0') * 4 + (str.charAt(i+1)-'0') * 2 + (str.charAt(i+2)-'0');
            sb.append(sum);
        }
        
        System.out.print(sb);
    }
}
    }
}