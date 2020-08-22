 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-08-22
  * URL   : https://app.codility.com/c/run/trainingM4BWDW-SR8
  *
  */

class Solution {
        public int solution(int[] A) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i=0; i<A.length; i++) {
            System.out.println(count.get(A[i]));

            if (count.get(A[i]) == null) {
                count.put(A[i], 1);
            } else {
               
            }
        }
    
    }

