 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-17
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/49994
  *
  */

import java.util.*;

class Solution {
    public int solution(String dirs) {
       Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;

        char[] dir = dirs.toCharArray();
        for (int i = 0; i < dir.length; i++) {
            char ch = dir[i];
            int dx = x;
            int dy = y;
            switch (ch) {
                case 'U' : dy++; break;
                case 'D' : dy--; break;
                case 'L' : dx--; break;
                case 'R' : dx++; break;
            }

            if (dx < -5 || dx > 5 || dy < -5 || dy > 5) continue;

            String load = "" + x + y + dx + dy;
            String load2 = "" + dx + dy + x + y;
            set.add(load);
            set.add(load2);
            x = dx;
            y = dy;
        }

        return set.size() / 2;
    }
}