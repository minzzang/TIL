 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-13
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42889
  *
  */

import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);

        double[] f = new double[N+2];
        Map<Integer, Double> map = new HashMap<>();

        int lenegth = stages.length;
        for (int i=0; i<stages.length; i++) {
            f[stages[i]]++;
        }

        for (int i=1; i<=N; i++) {
            int n = (int)f[i];
            f[i] = f[i] / lenegth;
            if (lenegth == 0) f[i] = 0;
            map.put(i, f[i]);
            lenegth -= n;
        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        int[] answer = new int[N];
        for (int i=0; i<N; i++) {
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}