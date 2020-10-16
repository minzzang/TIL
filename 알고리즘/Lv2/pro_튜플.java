 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-16
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/64065
  *
  */

import java.util.*;
class Solution {
    public int[] solution(String s) {
    s = s.substring(1, s.length()-1);

        StringBuffer sb = new StringBuffer();
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == '{') continue;
            if (s.charAt(i) == '}') continue;

            if (s.charAt(i) == ',' && s.charAt(i-1) == '}') {
                sb.append('/');
                continue;
            }
            sb.append(s.charAt(i));
        }
        String[] str = sb.toString().split("/");
        Arrays.sort(str, (o1, o2) -> {
            return Integer.compare(o1.length(), o2.length());
        });

        StringBuffer sb2 = new StringBuffer();
        for (String sa : str) {
            String[] splitStr = sa.split(",");
            for (int i=0; i<splitStr.length; i++) {
                if (sb2.indexOf(splitStr[i]) == -1) {
                    sb2.append(splitStr[i] + ",");
                    break;
                }
            }
        }
        sb2.deleteCharAt(sb2.length()-1);
        String[] answerStr = sb2.toString().split(",");
        int[] answer = new int[answerStr.length];
        for (int i=0; i<answer.length; i++) {
            answer[i] = Integer.parseInt(answerStr[i]);
        }

        return answer;
    }
}