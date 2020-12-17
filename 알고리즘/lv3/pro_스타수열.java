 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-17
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/70130
  *
  */

import java.util.*;
class Solution {
    private static boolean[] visited;
    
    public int solution(int[] a) {
      int answer = -1;
        int N = a.length;
        if (N < 2) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        for (Map.Entry<Integer, Integer> entry : list) {
            int key = entry.getKey();
            int value = entry. getValue();
            if (answer > value) continue;

            visited = new boolean[N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (a[i] == key) {
                    if (i != 0 && !visited[i-1] && a[i-1] != key) {
                        count++;
                        visited[i-1] = true;
                        continue;
                    }
                    if (i != N-1 && !visited[i+1] && a[i+1] != key) {
                        count++;
                        visited[i+1] = true;
                        continue;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        return answer * 2;
    }

}