 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-08-18
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42577
  *
  */

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);

        for (int i=0; i<phone_book.length; i++) {
            for (int j=i+1; j<phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }
}

