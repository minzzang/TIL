 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-19
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42888
  *
  */

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> name = new ArrayList<>();
        List<String> info = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (int i=0; i<record.length; i++) {
            String[] connectInfo = record[i].split(" ");

            if (connectInfo[0].equals("Enter")) {
                map.put(connectInfo[1], connectInfo[2]);
                name.add(connectInfo[1]);
                info.add("님이 들어왔습니다.");
            } else if (connectInfo[0].equals("Leave")) {
                name.add(connectInfo[1]);
                info.add("님이 나갔습니다.");
            } else {
                map.put(connectInfo[1], connectInfo[2]);
            }
        }

        String[] answer = new String[name.size()];
        for (int i=0; i<answer.length; i++) {
            String str = name.get(i) + info.get(i);
            answer[i] = str.replace(name.get(i), map.get(name.get(i)));
        }

        return answer;
    }
}