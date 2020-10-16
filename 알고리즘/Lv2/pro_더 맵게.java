 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-16
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42626
  *
  */

import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
      Queue<Integer> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.offer(i);
        }

        int answer = 0;
        while (queue.peek() <= K) {
            if (queue.size() == 1) return -1;
            
            int first = queue.poll();
            int second = queue.poll();

            queue.offer(first + (second * 2));
            answer++;
        }
        
        return answer;
    }
}