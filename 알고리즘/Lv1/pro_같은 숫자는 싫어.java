 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12906
  *
  */

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i=1; i<arr.length; i++) {
            if (stack.peek() == arr[i]) continue;
            stack.push(arr[i]);
        }

        int[] answer = new int[stack.size()];
        int index = 0;
        for (int i : stack) {
            answer[index++] = i;
        }
        return answer;
    }
}