 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-10
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/43164
  *
  */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


class Solution {
    
    private static boolean[] visited;
    
    private static int count;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        List<String> real = new ArrayList<>();
        real.add("ICN");
        sort(tickets);
        for (int j=0; j<tickets.length; j++) {
            if (tickets[j][0].equals("ICN")) {
                dfs(tickets, real, tickets[j][0]);
                break;
            }
        }
        
        String[] answer = new String[real.size()];

        for (int i=0; i<real.size(); i++) {
            answer[i] = real.get(i);
        }
        return answer;
    }
    
    private static void sort(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
    }
    
   private static void dfs(String[][] tickets, List<String> answer, String first) {

        if (!exists(tickets, first)) {
            return;
        }

        for (int i=0; i<tickets.length; i++) {

            if (visited[i]) continue;

            if (first.equals(tickets[i][0])) {
                visited[i] = true;
                answer.add(tickets[i][1]);
                count++;
                dfs(tickets, answer, tickets[i][1]);
                if (count != tickets.length) {
                    visited[i] = false;
                    count--;
                    answer.remove(answer.size()-1);
                }
            }

        }

    }

    private static boolean exists(String[][] tickets, String s) {
        for (int i=0; i<tickets.length; i++) {
            if (tickets[i][0].equals(s)) {
                return true;
            }
        }
        return false;
    }
}