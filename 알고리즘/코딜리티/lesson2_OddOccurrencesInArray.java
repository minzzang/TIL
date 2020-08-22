 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-08-22
  * URL   : https://app.codility.com/c/run/trainingM4BWDW-SR8
  *
  */

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<A.length; i++) {

            if (map.get(A[i]) == null) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                return key;
            }
        }

        return -1;
    }
}
