 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-09
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42747
  *
  */

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int left = 0, right = citations[citations.length-1];

        while (left <= right) {
            int mid = (left + right) / 2;
            int up = 0, down = 0;
            for (int i=0; i<citations.length; i++) {
                if (citations[i] >= mid) {
                    up++;
                } else if (citations[i] <= mid){
                    down++;
                }
            }
            if (up >= mid && down <= mid) {
                answer = Math.max(answer, mid);
            }

            if (up > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}