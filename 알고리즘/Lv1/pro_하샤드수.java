 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12947
  *
  */

class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int n = x;
        while (n >= 10) {
            sum += n % 10;
            n /= 10;
        } 
        sum += n;
        
        return x % sum == 0;
    }
}