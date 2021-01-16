 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-16
  * URL   : https://leetcode.com/problems/kth-missing-positive-number
  *
  */

class Solution {
    static int MAX = 2001;
    public int findKthPositive(int[] arr, int k) {
        int[] visited = new int[MAX];
        
        for (int i : arr) {
            visited[i]++;
        }
        
        int count = 0;
        for (int i = 1; i < MAX; i++) {
            if (visited[i] == 0) {
                count++;
            }
            if (count == k) return i;
        }
        return 0;
    }
}