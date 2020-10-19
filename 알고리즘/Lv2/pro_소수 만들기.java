 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-19
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12977
  *
  */

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;

        for (int i=0; i<length-2; i++) {
            for (int j=i+1; j<length-1; j++) {
                for (int k=j+1; k<length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if (isPrime(num)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    private static boolean isPrime(int num) {
        for (int i=2; i*i<=num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}