 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-19
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/68646
  *
  */

import java.util.*;
class Solution {
    public int solution(int[] a) {
       if (a.length == 1) return 1;
        if (a.length == 2) return 2;

        int answer = 2;
        int[] copyA = a.clone();
        Arrays.sort(copyA);
        int minIndex = 0;
        int leftMin = a[0];
        int rightMin = copyA[minIndex++];
        if (a[0] == copyA[0]) {
            leftMin = copyA[0];
            rightMin = copyA[minIndex++];
        }

        for (int i=1; i<a.length-1; i++) {
            if (rightMin == a[i]) {
                rightMin = copyA[minIndex++];
            }
            int max = Math.max(a[i], Math.max(leftMin, rightMin));
            if (a[i] != max) answer++;
            leftMin = Math.min(leftMin, a[i]);
        }
        return answer;
    }
}