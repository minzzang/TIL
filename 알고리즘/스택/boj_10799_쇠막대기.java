 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-15
  * URL   : https://www.acmicpc.net/problem/10799
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int count = 0;
        int barCount = 0;
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(')  {
                stack.push(ch);
                if (str.charAt(i+1) == '(') {
                    barCount++;
                }
            } else {
                stack.pop();
                if (str.charAt(i-1) == '(') {
                    count += stack.size();
                }
            }
        }
        System.out.println(count + barCount);
    }

}
