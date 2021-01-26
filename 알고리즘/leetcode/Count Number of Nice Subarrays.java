 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-26
  * URL   : https://leetcode.com/problems/count-number-of-nice-subarrays
  *
  */

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int start = 0, end = 0;
        int answer = 0, oddCount = 0;
        
        while (start < nums.length) {
            if (oddCount < k) {
                if (end == nums.length) break;
                if (nums[end++] % 2 == 1) oddCount++;
            } else {
                int end2 = end;
                if (oddCount == k) answer++;
                while (end2 < nums.length) {
                    if (nums[end2++] % 2 == 1) break;
                    answer++;
                }
                if (nums[start++] % 2 == 1) oddCount--;
            }
        }
        
        return answer;
    }
}