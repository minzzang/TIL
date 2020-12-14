 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-14
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12936
  *
  */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        long[] factorial = new long[n+1];
        boolean[] visited = new boolean[n+1];
        factorial[1] = 1;
        k = k - 1;

        for (int i = 2; i < factorial.length; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        int[] answer = new int[n];
        int idx = 0;
        for (int i = n-1; i > 0; i--) {
            long select = k / factorial[i];
            int index = checkLineUp(select, visited);

            answer[idx++] = index;
            visited[index] = true;
            k = k % factorial[i];
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                answer[idx] = i;
                break;
            }
        }

        return answer;
    }

    private static int checkLineUp(long select, boolean[] visited) {
        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) continue;

            if (count == select) {
                return i;
            }
            count++;
        }
        return count;
    }
}