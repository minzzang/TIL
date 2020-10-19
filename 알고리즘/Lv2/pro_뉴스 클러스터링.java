 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-19
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/17677
  *
  */

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> A = new HashMap<>();
        Map<String, Integer> B = new HashMap<>();

        for (int i=0; i<str1.length()-1; i++) {
            char prev = str1.charAt(i);
            char next = str1.charAt(i+1);
            if (prev >= 'a' && prev <= 'z' && next >= 'a' && next <= 'z') {
                String str = String.valueOf(prev) + String.valueOf(next);
                A.put(str, A.getOrDefault(str, 0) + 1);
            }
        }

        for (int i=0; i<str2.length()-1; i++) {
            char prev = str2.charAt(i);
            char next = str2.charAt(i+1);
            if (prev >= 'a' && prev <= 'z' && next >= 'a' && next <= 'z') {
                String str = String.valueOf(prev) + String.valueOf(next);
                B.put(str, B.getOrDefault(str, 0) + 1);
            }
        }

        Set<String> setA = A.keySet();
        Set<String> setB = B.keySet();

        double min = 0;
        double max = 0;
        for (String sub : setA) {
            if (B.get(sub) == null) {
                max += A.get(sub);
            } else {
                min += Math.min(A.get(sub), B.get(sub));
                max += Math.max(A.get(sub), B.get(sub));
            }
        }

        for (String sub : setB) {
            if (A.get(sub) == null) {
                max += B.get(sub);
            }
        }

        if (min == 0 && max == 0) return 65536;
        double j = min / max * 65536;

        return (int)j;
    }
}