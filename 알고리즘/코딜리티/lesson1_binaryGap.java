 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-08-20
  * URL   : https://app.codility.com/c/run/trainingZ89HFD-K4J
  *
  */

class Solution {
        public int solution(int N) {
            String byteString = Integer.toBinaryString(N);

            int count = 0;

            String[] s = byteString.split("1");
            int length = s.length;

            if (length == 1) return count;

            if (byteString.endsWith("0")) {
                length = length - 1;
            }

            for (int i=0; i<length; i++) {
                if (s[i].length() > count) {
                    count = s[i].length();
                }
            }
            return count;
        }
    }
