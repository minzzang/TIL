 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12935
  *
  */

import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i=0; i<arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }

        int[] answer = new int[arr.length - 1];
        for (int i=0; i<index; i++) {
            answer[i] = arr[i];
        }
        
        for (int i=index+1; i<arr.length; i++) {
            answer[index++] = arr[i];
        }

        return answer;
    }
}