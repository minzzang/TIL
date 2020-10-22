 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-22
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42627
  *
  */

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
          Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int startTime = 0;
        int index = 0;
        int count = 0;
        int answer = 0;
        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= startTime) {
                queue.offer(jobs[index++]);
            }

            if (queue.isEmpty()) {
                startTime = jobs[index][0];
            } else {
                int[] job = queue.poll();
                startTime += job[1];
                answer += startTime - job[0];
                count++;
            }
        }

        return answer / jobs.length;
    }
}