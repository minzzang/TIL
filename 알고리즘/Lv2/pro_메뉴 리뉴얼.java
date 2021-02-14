 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-02-14
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/72411
  *
  */

import java.util.*;
class Solution {
    private static Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
      map = new HashMap<>();
        for (String order : orders) {
            for (int i = 0; i < course.length; i++) {
                permutation(order, course[i], new StringBuilder(), 0);
            }
        }

        List<String> list = new ArrayList<>();
        for (int count : course) {
            int max = map.entrySet().stream()
                    .filter(e -> e.getKey().length() == count)
                    .filter(e -> e.getValue() > 1)
                    .map(Map.Entry::getValue)
                    .max(Integer::compareTo).orElseGet(() -> -1);

            for (Map.Entry<String, Integer> s : map.entrySet()) {
                if (s.getKey().length() == count && s.getValue() == max) {
                    list.add(s.getKey());
                }
            }
        }

        return list.stream()
                .sorted(String::compareTo)
                .toArray(String[]::new);
    }

    private static void permutation(String order, int n, StringBuilder sb, int index) {
        if (sb.length() == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = 0; i < order.length(); i++) {
            if (sb.length() != 0 
                || sb.charAt(sb.length()-1) > order.charAt(i)) continue; 
            if (sb.indexOf(String.valueOf(order.charAt(i))) == -1) {
                sb.append(order.charAt(i));
                permutation(order, n, sb, i+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}