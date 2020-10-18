 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-18
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12939
  *
  */

import java.util.*;
class Solution {
    public String solution(String s) {
         String answer = "";
        String[] str = s.split(" ");
         Arrays.sort(str, (o1, o2) -> 
                Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2)));
        
        answer = str[0] + " " + str[str.length-1];
        return answer;
    }
}