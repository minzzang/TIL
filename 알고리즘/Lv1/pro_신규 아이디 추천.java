 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-02-05
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/72410
  *
  */

class Solution {
    public String solution(String new_id) {
        String answer = "";
        String lowerId = new_id.toLowerCase();
        String match = "[^0-9a-zA-Z-_.]";
        lowerId = lowerId.replaceAll(match, "");
        
        match = "[.]{2,}";
        lowerId = lowerId.replaceAll(match, ".");
        
        if (!lowerId.isEmpty()) {
            if (lowerId.charAt(0) == '.') {
                lowerId = lowerId.substring(1);
            }
        } 
        if (!lowerId.isEmpty()) {
            if (lowerId.charAt(lowerId.length()-1) == '.') {
                lowerId = lowerId.substring(0, lowerId.length()-1);
            }
        } 
        
        if (lowerId.isEmpty()) lowerId += "a";
        
        if (lowerId.length() >= 16) {
            lowerId = lowerId.substring(0, 15);
            if (lowerId.charAt(lowerId.length() - 1) == '.') {
                lowerId = lowerId.substring(0, 14);
            }
        }
        
        if (lowerId.length() <= 2) {
            if (lowerId.length() == 1) {
                lowerId += lowerId + lowerId;
            } else {
                String last = lowerId.charAt(1) + "";
                lowerId += last;
            }
        }
        
        return lowerId;
    }
}