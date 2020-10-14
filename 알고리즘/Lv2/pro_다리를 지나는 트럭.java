 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-14
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42583
  *
  */

import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
       Queue<Integer> waitingTruck = new LinkedList<>();
        Queue<int[]> runningTruck = new LinkedList<>();

        for (int i : truck_weights) {
            waitingTruck.offer(i);

        }

        int currentWeight = 0;
        int answer = 0;
        while (!waitingTruck.isEmpty() || !runningTruck.isEmpty()) {
            if (!runningTruck.isEmpty()) {
                for (int[] i : runningTruck) {
                    i[1] -= 1;
                }
                if (runningTruck.peek()[1] == 0) {
                    currentWeight -= runningTruck.peek()[0];
                    runningTruck.poll();
                }
            }

            if (!waitingTruck.isEmpty()) {
                int firstTruck = waitingTruck.peek();
                if (currentWeight + firstTruck <= weight) {
                    currentWeight += firstTruck;
                    runningTruck.offer(new int[]{waitingTruck.poll(), bridge_length});
                }
            }

            answer++;
        }
        return answer;
    }
}