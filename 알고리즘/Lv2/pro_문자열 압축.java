 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-15
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/60057
  *
  */

class Solution {
    public int solution(String s) {
       int answer = s.length();

        int maxLength = s.length() / 2;
        for (int i=1; i<=maxLength; i++) {
            StringBuffer sb = new StringBuffer();
            String prevStr = s.substring(0, i);

            int count = 1;
            for (int j=i; j<=s.length()-i; j+=i) {
                String currentStr = s.substring(j, j+i);
                if (prevStr.equals(currentStr)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                        count = 1;
                    }
                    sb.append(prevStr);
                    prevStr = currentStr;
                }
            }
            if (count > 1) sb.append(count);
            sb.append(prevStr);
            if (s.length() % i > 0) {
                sb.append(s.substring(s.length() - s.length() % i));
            }
            answer = Math.min (answer, sb.length());
        }
        return answer;
    }
}