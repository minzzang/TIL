 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-09
  * URL   : https://leetcode.com/problems/longest-substring-without-repeating-characters
  *
  */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, ans = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        while (i < n && j < n) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i++));
                ans = Math.max(set.size(), ans);
            } else {
                set.remove(s.charAt(j++));
            }
        }
        return ans; 
    }
}