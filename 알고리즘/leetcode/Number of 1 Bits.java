 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-02-02
  * URL   : https://leetcode.com/problems/number-of-1-bits
  *
  */

public class Solution {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask = mask << 1;
        }
        return bits;
    }
}