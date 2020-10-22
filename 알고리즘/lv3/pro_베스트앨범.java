 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-22
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42579
  *
  */

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<int[]>> map = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            if (map.get(genres[i]) == null) {
                map.put(genres[i], new ArrayList<>());
                sumMap.put(genres[i], 0);
            }
            sumMap.put(genres[i], sumMap.get(genres[i]) + plays[i]);
            map.get(genres[i]).add(new int[]{plays[i], i});
        }

        for (String str : map.keySet()) {
            Collections.sort(map.get(str), (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o2[0], o1[0]);
            });
        }

        List<Map.Entry<String, List<int[]>>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> {
            return Integer.compare(sumMap.get(o2.getKey()), sumMap.get(o1.getKey()));
        });

        List<Integer> answerList = new ArrayList<>();
        for (int i=0; i<entries.size(); i++) {
            answerList.add(entries.get(i).getValue().get(0)[1]);

            if (entries.get(i).getValue().size() > 1) {
                answerList.add(entries.get(i).getValue().get(1)[1]);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}