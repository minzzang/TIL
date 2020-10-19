 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-19
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12951
  *
  */

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] strArr = s.split(" ");

        StringBuffer sb = new StringBuffer();
        for (String str : strArr) {
            char[] ch = str.toCharArray();
            if (str.equals("")) {
                sb.append(" ");
                continue;
            } else if (Character.isDigit(ch[0])) {
                sb.append(str);
            } else {
                ch[0] = (char)(ch[0]-32);
                sb.append(new String(ch));
            }
            sb.append(" ");
        }
        return s.charAt(s.length()-1) == ' ' ? sb.toString() : sb.deleteCharAt(sb.length() - 1).toString();
    }
}