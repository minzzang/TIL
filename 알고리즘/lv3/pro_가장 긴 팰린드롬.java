 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-14
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12904
  *
  */

class Solution
{
    public static boolean[][] dp;
    
    public int solution(String s)
    {
        int length = s.length();
        dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            char start = s.charAt(i);
            for (int j = length-1; j >= 0; j--) {
                char end = s.charAt(j);
                if (start == end) dp[i][j] = true;
            }
        }


        int answer = 1;
        for (int i = 0; i < length-1; i++) {
            for (int j = length-1; j > 0; j--) {
                if ((j - i + 1) <= answer) continue;
                if (dp[i][j] && check(i, j)) {
                    answer = j - i + 1;
                }
            }
        }
        
        return answer;
    }

    private static boolean check(int start, int end) {
        boolean flag = true;
        while (start < end) {
            start++;
            end--;
            if (!dp[start][start] || !dp[start][end]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}