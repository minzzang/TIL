 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-23
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42861
  *
  */

import java.util.*;
class Solution {
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> {
            return o1[2] - o2[2];
        });
        
        int[] parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        for (int[] cost : costs) {
            int prevNode = cost[0];
            int nextNode = cost[1];
            int minCost = cost[2];
            
            if (find(parent, prevNode, nextNode) == 1) continue;
            unionParent(parent, prevNode, nextNode);
            answer += minCost;
        }
        
        return answer;
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    private static int find(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        
        if (a == b) return 1;
        return 0;
    }

    private static int getParent(int[] parent, int n) {
        if (parent[n] == n) return n;
        return getParent(parent, parent[n]);
    }

}