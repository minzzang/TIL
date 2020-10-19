 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-19
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12953
  *
  */

import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int length = arr.length;

        if (length == 1) return arr[0];

        int preLcm = arr[0] * arr[1] / gcd(arr[0], arr[1]);
        if (length == 2) return preLcm;

        for (int i=2; i<arr.length; i++) {
            preLcm = arr[i] * preLcm / gcd(preLcm, arr[i]);
        }

        return preLcm;
    }

    private static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}