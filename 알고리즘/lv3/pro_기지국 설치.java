 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-18
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12979
  *
  */

class Solution {
    public int solution(int n, int[] stations, int w) {
       int answer = 0;
        int maxW = w * 2 + 1;

        int count = 0;
        for (int i = 0; i < stations.length; i++) {
            int station = stations[i];
            if (i == 0) {
                count = station - w - 1;
                answer += calculate(count, maxW);
            } else {
                int a = stations[i-1] + w + 1;
                int b = stations[i] - w - 1 ;

                count = b - a + 1;
                answer += calculate(count, maxW);
            }
        }
        count = n - (stations[stations.length-1] + w);
        answer += calculate(count, maxW);
        
        return answer;
    }

    private static int calculate(int count, int maxW) {
        if (count < 1) return 0;
        
        int num = count / maxW;
        if (count % maxW != 0) num++;
        return num;
    }
}