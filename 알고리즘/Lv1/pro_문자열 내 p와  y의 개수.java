 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12916
  *
  */

class Solution {
    boolean solution(String s) {
        char[] ch = s.toCharArray();
        
        int yCount = 0, pCount = 0;
        for (char c : ch) {
            if (c == 'p' || c == 'P') {
                pCount++;
            } else if (c == 'y' || c == 'Y') {
                yCount++;
            }
        }
        return pCount == yCount;
    }
}