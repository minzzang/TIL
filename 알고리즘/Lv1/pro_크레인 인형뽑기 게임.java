 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-11
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/64061
  *
  */

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
       int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<moves.length; i++) {
            int n = moves[i];
            for (int j=0; j<board.length; j++) {
                if (board[j][n-1] == 0) continue;

                if (!stack.isEmpty() &&
                        stack.peek() == board[j][n-1]) {
                    stack.pop();
                    answer+=2;
                } else {
                    stack.push(board[j][n-1]);
                }
                board[j][n-1] = 0;
                break;
            }
        }

        return answer;
    }
}