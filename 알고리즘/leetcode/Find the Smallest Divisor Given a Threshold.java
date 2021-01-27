 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-27
  * URL   : https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
  *
  */

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
      int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }

        int left = 1, right = max;
        int temp = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i] / mid;
                if (nums[i] % mid != 0) sum++;
            }

            if (threshold < sum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}