 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-20
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/17683
  *
  */

import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
      String answer = "";

        m = toLower(m);

        List<String[]> list = new ArrayList<>();
        for (int i=0; i<musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            String[] startTime = info[0].split(":");
            String[] endTime = info[1].split(":");
            String musicTitle = info[2];
            int musicLength = getMusicLength(startTime, endTime);

            StringBuffer sb = new StringBuffer();
            String melodyInfo = toLower(info[3]);
            for (int j=0; j<melodyInfo.length(); j++) {
                sb.append(melodyInfo.charAt(j));
                if (j != melodyInfo.length() -1) sb.append(",");
            }

            String[] melody = sb.toString().split(",");
            StringBuffer repeatingMelody = new StringBuffer();
            for (int k=0; k<musicLength; k++) {
                repeatingMelody.append(melody[k % melody.length]);
            }

            int index = repeatingMelody.indexOf(m);
            if (index != -1) {

                String[] result = new String[3];
                result[0] = i + "";
                result[1] = musicTitle;
                result[2] = musicLength + "";

                list.add(result);
            }
        }

        if (list.isEmpty()) {
            return "(None)";
        } else if (list.size() == 1) {
            return list.get(0)[1];
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1[2].equals(o2[2])) {
                return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
            }
            return Integer.compare(Integer.parseInt(o2[2]), Integer.parseInt(o1[2]));
        });

        return list.get(0)[1];
    }

    private static String toLower(String s) {
        s = s.replaceAll("C#", "c");
        s = s.replaceAll("D#", "d");
        s = s.replaceAll("F#", "f");
        s = s.replaceAll("G#", "g");
        s = s.replaceAll("A#", "a");

        return s;
    }

    private static int getMusicLength(String[] startTime, String[] endTime) {
        int minute = (Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0])) * 60;
        int second = Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]);
        return minute + second;
    }
}