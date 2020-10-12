 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12930
  *
  */

class Solution {
    public String solution(String s) {
       StringBuffer sb = new StringBuffer();
        char[] ch = s.toCharArray();
        
        int index = 0;
        for (char c : ch) {
            if (c == ' ') {
                sb.append(" ");
                index = 0;
                continue;
            }
            
            if (index++ % 2 == 0) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }
}