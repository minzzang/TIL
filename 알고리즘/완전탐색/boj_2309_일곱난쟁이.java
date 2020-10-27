 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-27
  * URL   : https://www.acmicpc.net/problem/2309
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static List<Integer> list = new ArrayList<>();
    private static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];

        for (int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(arr, 0, 0, 0);

    }

    private static void dfs(int[] arr, int index, int depth, int sum) {
        if (depth == 7) {

            if (!flag && sum == 100) {
                flag = true;
                Collections.sort(list);
                for (int i : list) {
                    System.out.println(i);
                }
            }
            return;
        }

        for (int i=index; i<9; i++) {
            list.add(arr[i]);
            dfs(arr, i+1, depth+1, sum+arr[i]);
            list.remove(list.size()-1);
        }
    }

}


