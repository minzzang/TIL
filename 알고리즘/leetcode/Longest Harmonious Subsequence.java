 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-02-04
  * URL   : https://leetcode.com/problems/longest-harmonious-subsequence
  *
  */

class Solution {
    public int findLHS(int[] nums) {
        int num = 0, plus = 0, minus = 0;
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            for (int j = i+1; j < nums.legnth; j++) {
                if (num == nums[j]) {
                    plus++;
                    minus++;
                } else if (num - 1 == nums[j]) {
                    minus++;
                } else if (num +1 == nums[j]) {
                    plus++;
                }
            }
        }        
    }
}