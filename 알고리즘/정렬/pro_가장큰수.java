 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-09
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42746
  *
  */

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
         String[] strings = new String[numbers.length];

        for (int i=0; i<strings.length; i++) {
            strings[i] = numbers[i] + "";
        }

        Arrays.sort(strings, (o1, o2) ->(o2+o1).compareTo(o1+o2));

        StringBuffer sb = new StringBuffer();
        if (strings[0].equals("0")) {
            sb.append(0);
        } else {
            for (String s : strings) {
                sb.append(s);
            }
        }

        return String.valueOf(sb);
    }
}