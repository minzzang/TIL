 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-14
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42883
  *
  */

import java.util.*;
class Solution {
    public String solution(String number, int k) {
     int prevIndex = -1;
        char[] numberArr = number.toCharArray();

        char max = '0';
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<number.length()-k; i++) {

            max = '0';
            for (int j=prevIndex+1; j<i+k+1; j++) {
                if (max < numberArr[j]) {
                    max = numberArr[j];
                    prevIndex = j;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}