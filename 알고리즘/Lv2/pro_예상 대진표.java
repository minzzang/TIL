 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-19
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12985
  *
  */

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while (n != 1) {
            answer++;
            if (Math.abs(b-a) == 1 && Math.ceil(a / 2.0) == Math.ceil(b / 2.0)) {
                break;
            }

            a = (int)Math.ceil(a / 2.0);
            b = (int)Math.ceil(b / 2.0);

            n /= 2;
        }
        return answer;
    }
}