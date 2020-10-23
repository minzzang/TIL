 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-23
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/43238
  *
  */

import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long N = n;

        long left = 0;
        long right = (N / times.length + 1) * times[times.length-1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i=0; i<times.length; i++) {
                sum += mid / times[i];
            }

            if (sum >= N) {
                right = (long)mid - 1;
            } else {
                left = (long)mid + 1;
                answer = left;
            }
        }
        
        return left;
    }
}