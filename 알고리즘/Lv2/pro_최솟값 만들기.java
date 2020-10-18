 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-18
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12941
  *
  */

import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
         int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i=0; i<A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }
}