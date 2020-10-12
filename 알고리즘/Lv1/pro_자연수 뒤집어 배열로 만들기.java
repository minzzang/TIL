 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12932
  *
  */

class Solution {
    public int[] solution(long n) {
        String str = n + "";
        char[] ch = str.toCharArray();
        int[] answer = new int[ch.length];
        
        int index = ch.length - 1;
        for (char c : ch) {
            answer[index--] = c - '0'; 
        }

        return answer;
    }
}