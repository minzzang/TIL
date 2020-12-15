 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-15
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/67258
  *
  */

import java.util.*;

class Solution {
    public static int MIN = Integer.MAX_VALUE;
    
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String s : gems) {
            set.add(s);
        }

        Map<String, Integer> map = new HashMap<>();
        List<Point> list = new ArrayList<>();
        int s = 0, e = 0;
        while (e <= gems.length) {
            if (map.size() < set.size()) {
                if (e == gems.length) break;
                map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);
                e++;
            } else {
                if (map.get(gems[s]) == 1) {
                    map.remove(gems[s]);
                } else {
                    map.put(gems[s], map.get(gems[s]) - 1);
                }
                s++;
            }

            if (map.size() == set.size()) {
                if (e - (s + 1) < MIN) {
                    list.add(new Point(s+1, e));
                    MIN = e - (s + 1);
                }
            }
        }

        int[] answer = new int[2];
        for (Point p : list) {
            if (p.end - p.start == MIN) {
                answer[0] = p.start;
                answer[1] = p.end;
                break;
            }
        }
        return answer;
    }
}

class Point {
    int start;
    int end;

    Point(int start, int end) {
        this.start = start;
        this.end = end;
    }
}