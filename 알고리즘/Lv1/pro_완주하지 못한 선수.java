 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42576
  *
  */

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
       String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0) + 1);
        }
        for (int i=0; i<participant.length; i++) {
            if (map.get(participant[i]) == null
                    || map.get(participant[i]) == 0) {
                answer = participant[i];
                break;
            }
            map.put(participant[i], map.get(participant[i]) - 1);
        }
        return answer;
    }
}