 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-10
  * URL   : https://www.acmicpc.net/problem/8111
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Queue<FavoriteNum> queue = new LinkedList<>();
            queue.offer(new FavoriteNum("0", "0"));

            while (!queue.isEmpty()) {
                FavoriteNum favoriteNum = queue.poll();

                if (favoriteNum.original.length() > 100) {
                    sb.append("BRAK");
                    break;
                }
                int a = Integer.parseInt(favoriteNum.divided);
                if (favoriteNum.original.length() > String.valueOf(N).length()) {

                    if (a % N == 0) {
                        sb.append(favoriteNum.original).append("\n");
                        break;
                    }
                }

                queue.offer(new FavoriteNum(favoriteNum.original + "0", (a % N) + "0"));
                queue.offer(new FavoriteNum(favoriteNum.original + "1", (a % N) + "1"));
            }

        }
        System.out.println(sb);
    }
}

class FavoriteNum {
    String original;
    String divided;

    FavoriteNum(String original, String divided) {
        this.original = original;
        this.divided = divided;
    }
}