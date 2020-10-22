 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-22
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42628
  *
  */

import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
     Queue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        for (int i=0; i<operations.length; i++) {
            String[] op = operations[i].split(" ");
            if (op[0].equals("I")) {
                pq.offer(Integer.parseInt(op[1]));
                pq2.offer(Integer.parseInt(op[1]));
                continue;
            }
            if (pq.isEmpty()) continue;

            if (op[1].equals("1")) {
                int num = pq2.poll();
                pq.remove(num);
            } else {
                int num = pq.poll();
                pq2.remove(num);
            }
        }

        if (pq.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{pq2.peek(), pq.peek()};
    }
}