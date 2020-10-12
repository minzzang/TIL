 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12917
  *
  */

import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        
        StringBuffer sb = new StringBuffer(new String(ch));
        return sb.reverse().toString();
    }
}