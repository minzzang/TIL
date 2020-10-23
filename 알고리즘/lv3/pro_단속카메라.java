 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-23
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42884
  *
  */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        Queue<int[]> queue = new PriorityQueue<>(
                (o1, o2) -> o1[1] - o2[1]
        );
        for (int[] route : routes) {
            queue.offer(route);
        }

        int camera = 0;
        int routesIndex = 0;
        while (routesIndex != routes.length) {
            int[] leavingCar = queue.poll();

            while (routesIndex < routes.length && routes[routesIndex][0] <= leavingCar[1]) {
                queue.remove(routes[routesIndex]);
                routesIndex++;
            }

            camera++;
        }
        return camera;
    }
}