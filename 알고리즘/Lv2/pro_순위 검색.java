 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-02-15
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/72412
  *
  */

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};

        for (String one : query) {
            String[] ones = one.split("and ");
            String food = ones[3].split(" ")[0];
            String score = ones[3].split(" ")[1];

            Arrays.stream(info)
                    .filter(s -> s.contains(food));
        }
        return answer;
    }
}