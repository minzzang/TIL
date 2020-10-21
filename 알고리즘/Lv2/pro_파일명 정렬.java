 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-21
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/17686
  *
  */

import java.util.*;
class Solution {
    public String[] solution(String[] files) {
     List<String[]> list = new ArrayList<>() ;

        for (int i=0; i<files.length; i++) {
            String[] file = getFile(files[i], i);
            list.add(file);
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1[1].toLowerCase().equals(o2[1].toLowerCase())) {
                if (Integer.parseInt(o1[2]) == (Integer.parseInt(o2[2]))) {
                    return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
                }
                return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
            }
            return o1[1].toLowerCase().compareTo(o2[1].toLowerCase());
        });

        String[] answer = new String[list.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.get(i)[1] + list.get(i)[2] + list.get(i)[3];
        }
        return answer;
    }

    private static String[] getFile(String file, int index) {
        StringBuffer head = new StringBuffer();
        StringBuffer number = new StringBuffer();
        String tail = "";
        int numberStartIndex = 0;
        int tailStartIndex = 0;
        for (int k=0; k<file.length(); k++) {
            if (!Character.isDigit(file.charAt(k))) {
                head.append(file.charAt(k));
            }
            if (Character.isDigit(file.charAt(k+1))) {
                numberStartIndex = k + 1;
                break;
            }
        }

        int numCount = 0;
        for (int j=numberStartIndex; j<file.length(); j++) {
            if (!Character.isDigit(file.charAt(j))) break;
            if (numCount == 5) break;
            number.append(file.charAt(j));
            tailStartIndex = j + 1;
            numCount++;
        }

        tail = file.substring(tailStartIndex);

        return new String[]{index+"", head.toString(), number.toString(), tail};
    }
}