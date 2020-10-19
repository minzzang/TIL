 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-19
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12981
  *
  */

import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        String prev = words[0];
        map.put(prev,1);

        for (int i=1; i<words.length; i++) {
            String next = words[i];
            if (map.get(next) != null || prev.charAt(prev.length()-1) != next.charAt(0)) {
                index = i;
                break;
            }
            map.put(next, 1);
            prev = next;
        }

        if (index == 0) return new int[]{0, 0};

        int[] answer = new int[2];
        answer[0] = index % n + 1;
        answer[1] = index / n + 1;
        return answer;
    }
}