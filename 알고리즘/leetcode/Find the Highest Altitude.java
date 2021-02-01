 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-02-01
  * URL   : https://leetcode.com/problems/find-the-highest-altitude
  *
  */

class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;
        for (int i : gain) {
            currentAltitude += i;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }
        return maxAltitude;  
    }
}