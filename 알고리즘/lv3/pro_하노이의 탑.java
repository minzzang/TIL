 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-16
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12946
  *
  */

import java.util.*;
class Solution {
    public static List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];

        int index = 0;
        for (int[] i : list) {
            answer[index][0] = i[0];
            answer[index++][1] = i[1];
        }
        return answer;
    }

    private static void hanoi(int n, int from, int by, int to) {
        if (n == 1) {
            move(from, to);
        } else {
            hanoi(n-1, from, to, by);
            move(from, to);
            hanoi(n-1, by, from, to);
        }
    }

    private static void move(int from, int to) {
        list.add(new int[]{from, to});
    }
}