 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-08
  * URL   : https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent
  *
  */

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0, i2 = 0;
        int o1 = 0, o2 = 0;

        while (o1 < word1.length && o2 < word2.length) {
            String s1 = word1[o1], s2 = word2[o2];
            if (s1.charAt(i1) != s2.charAt(i2)) return false;

            if (i1 < s1.length() - 1) {
                i1++;
            } else {
                i1 = 0;
                o1++;
            }

            if (i2 < s2.length() - 1) {
                i2++;
            } else {
                i2 = 0;
                o2++;
            }
        }

        return i1 == i2;
    }
}