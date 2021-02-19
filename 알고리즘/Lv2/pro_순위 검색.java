 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-02-19
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/72412
  *
  */

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        int index = 0;
        for (String one : query) {
            String[] ones = one.split("and ");
            answer[index++] = count(info, ones);
        }
        return answer;
    }

    private static int count(String[] info, String[] ones) {
        String lang = ones[0].trim();
        String part = ones[1].trim();
        String career = ones[2].trim();
        String food = ones[3].split(" ")[0].trim();
        String score = ones[3].split(" ")[1].trim();

        int count = 0;
        for (String s : info) {
           String[] row = s.split(" ");
           if (!lang.equals("-") && !lang.equals(row[0])) continue;
           if (!part.equals("-") && !part.equals(row[1])) continue;
           if (!career.equals("-") && !career.equals(row[2])) continue;
           if (!food.equals("-") && !food.equals(row[3])) continue;
           if (Integer.parseInt(score) > Integer.parseInt(row[4])) continue;

           count++;
        }
        return count;
    }
}
