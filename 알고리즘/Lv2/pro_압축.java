 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-21
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/17684
  *
  */

import java.util.*;
class Solution {
    private static Map<String, Integer> map = new HashMap<>();
    
    public int[] solution(String msg) {
      int indexLength = 27;
        for (int i=1; i<indexLength; i++) {
            map.put(String.valueOf((char)('A'+ i-1)), i);
        }

        int start = 0;
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        while (true) {
            String wc = msg.charAt(start) + "";
            while (map.containsKey(wc)) {
                if (start == msg.length() - 1) {
                    list.add(map.get(wc));
                    flag = false;
                    break;
                }
                wc += msg.charAt(++start);
            }

            if (!flag) break;
            
            String w = wc.substring(0, wc.length()-1);
            list.add(map.get(w));
            map.put(wc, indexLength++);
        }
        
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}