 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-04
  * URL   : https://leetcode.com/problems/check-array-formation-through-concatenation
  *
  */

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
       for (int[] piece : pieces) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < piece.length; j++) {
                for (int i : arr) {
                    if (i == piece[j]) {
                        list.add(j);
                    }
                }
            }

            if (list.size() != piece.length) return false;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i) != i) return false;
            }
        }

        return true;
    }
}