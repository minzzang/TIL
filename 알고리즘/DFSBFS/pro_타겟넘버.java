 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-01
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/43165
  *
  */

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private static int dfs(int[] numbers, int target, int sum, int index) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        } else {
            return dfs(numbers, target, sum+numbers[index], index+1)
                    + dfs(numbers, target, sum-numbers[index], index+1);
        }
    }
}