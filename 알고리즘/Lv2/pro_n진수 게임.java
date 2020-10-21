 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-21
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/17687
  *
  */

class Solution {
    private static char[] ch;
    
    public String solution(int n, int t, int m, int p) {
        ch = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        StringBuffer sb = new StringBuffer("0");
        int cnt = 1;
        while (sb.length() < t * m) {
            sb.append(convert(cnt++, n));

        }

        StringBuffer answer = new StringBuffer();
        for (int i=0; i<sb.length(); i++) {
            if (answer.length() == t) break;
            if (i % m == p-1) answer.append(sb.charAt(i));
        }

        return answer.toString();
    }
    
    private static String convert(int num, int n) {
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            sb.append(ch[num % n]);
            num /= n;
        }
        return sb.reverse().toString();
    }
}