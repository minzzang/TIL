 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-15
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/64062
  *
  */

class Solution {
    public int solution(int[] stones, int k) {
        int left = 0;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < stones.length; i++) {
            right = Math.max(right, stones[i]);
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            boolean flag = true;
            int jump = 0;

            for (int i = 0; i < stones.length; i++) {
                if (stones[i] <= mid) {
                    jump++;
                } else {
                    jump = 0;
                }
                
                if (jump == k) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}