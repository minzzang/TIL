 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-22
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/49189
  *
  */

import java.util.*;

class Solution {
    private static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
       visited = new boolean[n+1];

        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        List<Integer> distance = new ArrayList<>();
        int max = 0;
        while (!queue.isEmpty()) {
            int[] num = queue.poll();
            distance.add(num[1]);
            max = Math.max(num[1], max);

            for (int i : list.get(num[0])) {
                if (visited[i]) continue;
                visited[i] = true;
                queue.offer(new int[]{i, num[1] + 1});
            }
        }

        int answer = 0;
        for (int i : distance) {
            if (i == max) answer++;
        }

        return answer;
    }
}