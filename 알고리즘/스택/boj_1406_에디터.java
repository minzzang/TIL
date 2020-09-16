 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-16
  * URL   : https://www.acmicpc.net/problem/1406
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int length = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        StringTokenizer st;

        char[] input = str.toCharArray();
        for (char ch : input) {
            leftStack.push(ch);
        }

        for (int i=0; i<length; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if ("L".equals(command)) {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if ("D".equals(command)) {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            } else if ("B".equals(command)) {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            } else {
                leftStack.push(st.nextToken().charAt(0));
            }
        }

        for (int i=0; i<leftStack.size(); i++){
            System.out.print(leftStack.get(i));
        }
        for (int i=rightStack.size()-1; i>=0; i--){
            System.out.print(rightStack.get(i));
        }
    }

}