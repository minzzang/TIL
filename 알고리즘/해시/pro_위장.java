 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-10
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42578
  *
  */

import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            if (map.get(cloth[1]) == null) {
                map.put(cloth[1], 1);
            } else {
                map.put(cloth[1], map.get(cloth[1]) + 1);
            }
        }

        int answer = 1;
        for (String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }
        return answer - 1;
    }

 }