 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-02-13
  * URL   : https://leetcode.com/problems/shortest-distance-to-a-character
  *
  */

class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                list.add(i);
            }
        }
        
        int[] answer = new int[s.length()];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for (int i = 0; i < answer.length; i++) {
            for (int j : list) {
                int index = Math.abs(j - i);
                if (index < answer[i]) answer[i] = index;
            }
        }
        
        return answer;
    }
}