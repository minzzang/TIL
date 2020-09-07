 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-07
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/43162
  *
  */

class Solution {
    
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int j=0; j<visited.length; j++) {
            if (!visited[j]) {
                dfs(computers, j);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(int[][] computers,int index) {

        if (visited[index] == false) {
            visited[index] = true;
        }

        for (int i=0; i<computers.length; i++) {
            if (computers[index][i] == 1 && !visited[i]) {
                dfs(computers, i);
            }
        }
    }
}
