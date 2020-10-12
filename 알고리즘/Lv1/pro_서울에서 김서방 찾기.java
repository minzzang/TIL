 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-12
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12919
  *
  */

class Solution {
    public String solution(String[] seoul) {
        int i = 0;
        String answer = "";
        for (String str : seoul) {
            if (str.equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
            i++;
        }
        return answer;
    }
}