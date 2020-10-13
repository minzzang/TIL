 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-13
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/67256
  *
  */

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        int leftPosition = 10;
        int rightPosition = 12;

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<numbers.length; i++) {
            int num = numbers[i];
            if (num == 0) num = 11;
            if (num % 3 == 1) {
                sb.append("L");
                leftPosition = num;
            } else if (num % 3 == 0) {
                sb.append("R");
                rightPosition = num;
            } else {
                int l = findLeftPosition(leftPosition, num);
                int r = findRightPosition(rightPosition, num);

                if (l == r) {
                    if (hand.equals("right")) {
                        sb.append("R");
                        rightPosition = num;
                    } else {
                        sb.append("L");
                        leftPosition = num;
                    }
                } else if (l > r) {
                    sb.append("R");
                    rightPosition = num;
                } else {
                    sb.append("L");
                    leftPosition = num;
                }
            }
        }
        

        return sb.toString();
    }

    private static int findRightPosition(int position, int num) {
        int count = 0;
        if (position % 3 == 0) {
            count = Math.abs(position - num - 1) / 3 + 1;
        } else {
            count = Math.abs(position - num) / 3;
        }
        return count;
    }

    private static int findLeftPosition(int position, int num) {
        int count = 0;
        if (position % 3 == 1) {
            count = Math.abs(position - num + 1) / 3 + 1;
        } else {
            count = Math.abs(position - num) / 3;
        }
        return count;
    }

}