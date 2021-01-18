 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-18
  * URL   : https://leetcode.com/problems/max-number-of-k-sum-pairs
  *
  */

class Solution {
    public int maxOperations(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int count = 0;
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            if (k - nums[left] == nums[right]) {
                count++;
                left++;
                right--;
            } else if (k - nums[left] > nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        
    
        return count;
    }
}