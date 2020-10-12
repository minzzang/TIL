 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-11
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/68644
  *
  */

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
         Set<Integer> set = new HashSet<>();
        for (int i=0; i<numbers.length-1; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[set.size()];
        int index = 0;
        for (int i : set) {
            answer[index++] = i;
        }
        Arrays.sort(answer);
        return answer;
    }
}