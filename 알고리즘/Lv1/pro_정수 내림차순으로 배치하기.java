 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12933
  *
  */

import java.util.*;

class Solution {
    public long solution(long n) {
        String str = n + "";
        char[] ch = str.toCharArray();
        int[] arr = new int[ch.length];

        int index = 0;
        for (char c : ch) {
            arr[index++] = c - '0';
        }
        Arrays.sort(arr);
        
        StringBuffer sb = new StringBuffer();
        for (int i : arr) {
            sb.append(i);
        }

        return Long.parseLong(sb.reverse().toString());
    }
}