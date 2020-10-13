 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-13
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12948
  *
  */

class Solution {
    public String solution(String phone_number) {
        StringBuffer sb = new StringBuffer();
        char[] ch = phone_number.toCharArray();
        
        for (int i=0; i<ch.length; i++) {
            if (i < ch.length - 4) {
                sb.append("*");
            } else {
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}