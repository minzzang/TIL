 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-10
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42839
  *
  */

import java.util.Arrays;

class Solution {
    
    private static int count;

    private static boolean[] visited;
    
    public int solution(String numbers) {
        String[] numbersArray = numbers.split("");
        Arrays.sort(numbersArray);
        visited = new boolean[numbers.length()];

        boolean[] sameNumberCheck = new boolean[10];

        for (int i=0; i<numbersArray.length; i++) {
            int numberIndex = Integer.parseInt(numbersArray[i]);

            if (numbersArray[i].equals("0")) continue;
            if (sameNumberCheck[numberIndex]) continue;

            sameNumberCheck[numberIndex] = true;
            visited[i] = true;
            dfs(numbersArray, numbersArray[i]);
            visited[i] = false;
        }

        return count;
    }
    
    private static void dfs(String[] numbersArray, String str) {

        if (isPrimeNumber(str)) count ++;

        if (str.length() == numbersArray.length) return;

        for (int i=0; i<numbersArray.length; i++) {

            if (visited[i]) continue;

            visited[i] = true;
            dfs(numbersArray, str+numbersArray[i]);
            visited[i] = false;
        }
    }

    public static boolean isPrimeNumber(String s) {
        int number = Integer.parseInt(s);

        if(number <= 1) {
            return false;
        }
        for(int i = 2; i * i <= number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}