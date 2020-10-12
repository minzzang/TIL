 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12910
  *
  */

import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if (i % divisor == 0) list.add(i);
        }
        if (list.isEmpty()) list.add(-1);

        Collections.sort(list);

        return list.stream().mapToInt(i -> i).toArray();
    }
}