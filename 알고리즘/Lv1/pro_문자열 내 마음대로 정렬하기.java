 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12915
  *
  */

import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) == o2.charAt(n)) {
                return (o1).compareTo(o2);
            }
            return o1.charAt(n) - o2.charAt(n);
        });
        return strings;
    }
}