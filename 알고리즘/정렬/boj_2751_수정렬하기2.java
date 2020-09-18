 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-18
  * URL   : https://www.acmicpc.net/problem/2751
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int length = Integer.parseInt(br.readLine());
       List<Integer> list = new ArrayList<>();

       for (int i=0; i<length; i++) {
           list.add(Integer.parseInt(br.readLine()));
       }
       Collections.sort(list);

       StringBuffer sb = new StringBuffer();
       for (int i : list) {
           sb.append(i + "\n");
       }
       System.out.println(sb);


    }
}