 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-13
  * URL   : https://leetcode.com/problems/word-ladder
  *
  */

class Solution {
    static String BEGIN, END;
    static List<String> WORD;
    static int COUNT, INF = 5002;
    static boolean[] visited;
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        
        BEGIN = beginWord;
        END = endWord;
        WORD = wordList;
        COUNT = INF;
        visited = new boolean[wordList.size()];
        
        dfs(BEGIN, 0);
        
        return COUNT == INF ? 0 : COUNT+1;
    }
    
    private void dfs(String beginWord, int depth) {
        
        if (beginWord.equals(END)) {
            COUNT = Math.min(COUNT, depth);
            return;
        }
        
        for (int i = 0 ; i < WORD.size(); i++) {
            if (visited[i]) continue;
            if (isAble(beginWord, WORD.get(i))) {
                visited[i] = true;
                dfs(WORD.get(i), depth + 1);
                visited[i] = false;
            }
            
        }
    }
    
    private boolean isAble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
            if (count > 1) return false;
        }
        
        return true;
    }
        
}