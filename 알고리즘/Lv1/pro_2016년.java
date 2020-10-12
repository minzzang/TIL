 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12901
  *
  */

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] calendar = {31, 29, 31, 30, 31, 30 ,31, 31, 30, 31, 30, 31};
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        int sum = b;
        for (int i=0; i<a-1; i++) {
            sum += calendar[i];
        }
        
        return day[sum % 7];
    }
}