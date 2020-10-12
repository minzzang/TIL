 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12926
  *
  */

class Solution {
    public String solution(String s, int n) {
       char[] ch = s.toCharArray();

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<ch.length; i++) {
            if (ch[i] == ' ') {
                sb.append(ch[i]);
            } else if (ch[i] >= 'a' && ch[i] <= 'z') {
                sb.append((char)((ch[i] - 'a' + n) % 26 + 'a'));
            } else {
                sb.append((char)((ch[i] - 'A' + n) % 26 + 'A'));
            }
        }
        return sb.toString();
    }
}