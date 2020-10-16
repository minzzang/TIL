 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-16
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12909
  *
  */

class Solution {
    boolean solution(String s) {
       char[] c = s.toCharArray();
        int count = 0;
        for (int i=0; i<c.length; i++) {
            if (c[i] == '(') {
                count++;
            } else {
                if (count == 0) return false;
                count--;
            }
        }

        return count == 0;
    }
}
}