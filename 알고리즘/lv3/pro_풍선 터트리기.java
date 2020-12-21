 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-21
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/68646
  *
  */

import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 2;
        int [][] map = new int [a.length][2];
        int l = a[0];
        int r = a[a.length-1];

        for (int i = 1; i < a.length-1; i++) {
            if (l > a[i]) l = a[i];
            map[i][0] = l;
        }

        for (int i = a.length-2; i > 0; i--) {
            if (r > a[i]) r = a[i];
            map[i][1] = r;
        }

        for (int i = 1; i < a.length-1; i++) {
            if (a[i] <= map[i][0] || a[i] <= map[i][1]) answer++;
        }

        return answer;
    }
}