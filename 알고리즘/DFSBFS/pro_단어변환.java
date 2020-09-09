 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-09
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/43163
  *
  */

class Solution {
    
    private static int minimum;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length + 1];
        minimum = words.length + 1;

        for (int i=0; i<words.length; i++) {
            if (words[i].equals(target)) {
                dfs(words, begin, target, visited, 0);
            }
        }

        if (minimum == words.length + 1) {
            return 0;
        }
        return minimum;
    }
    
    private static void dfs(String[] words, String begin, String target, boolean[] visited, int index) {

        if (begin.equals(target)) {
            minimum = minimum > index ? index : minimum;
            return;
        }

        for (int i=0; i<words.length; i++) {
            if (visited[i]) continue;
            
            if (isOneCharDifferent(begin, words[i])) {
                visited[i] = true;
                dfs(words, words[i], target, visited, index+1);
                visited[i] = false;
            }
        }
    }
    
    private static boolean isOneCharDifferent(String str1, String str2) {

        int differentCharCount = 0;

        for(int j=0; j<str2.length(); j++) {
            if (str1.charAt(j) != str2.charAt(j)) {
                differentCharCount++;
            }
        }
        return differentCharCount == 1;
    }
}