 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-17
  * URL   : https://www.acmicpc.net/problem/11652
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int length = Integer.parseInt(br.readLine());
       long[] cards = new long[length];

       for (int i=0; i<length; i++) {
           cards[i] = Long.parseLong(br.readLine());
       }
       Arrays.sort(cards);

       int count = 0;
       long answer = cards[0];
       List<Integer> list = new ArrayList<>();
       for (int i=0; i<cards.length; i++) {
           if (cards[i] == answer) {
               count++;
           } else {
               list.add(count);
               count = 1;
               answer = cards[i];
           }
           if (i == cards.length-1) {
               list.add(count);
           }
       }

       int max = 0;
       int sum = 0;
       int m = 0;
       for (int i=0; i<list.size(); i++) {
           int n = list.get(i);
           sum += n;
           if (list.get(i) > max) {
               max = n;
               m = sum;
           }
       }
       System.out.println(cards[m-1]);

    }
}