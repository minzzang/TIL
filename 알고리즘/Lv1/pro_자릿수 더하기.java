 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12931
  *
  */

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = n + "";
        char[] ch = str.toCharArray();
        
        for (char c : ch) {
            answer += c - '0';
        }

        return answer;
    }
}