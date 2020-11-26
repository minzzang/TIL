 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-26
  * URL   : https://www.acmicpc.net/problem/10973
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index = -1;
        for (int i = N-1; i > 0; i--) {
            if (arr[i] < arr[i-1]) {
                index = i-1;
                break;
            }
        }
        if (index == -1) {
            System.out.println(index);
            return;
        }

        int upperBound = 0;
        int upperBoundIndex = 0;
        for (int i = index + 1; i < N; i++) {
            if (arr[index] > arr[i] && upperBound < arr[i]) {
                upperBound = arr[i];
                upperBoundIndex = i;
            }
        }
        swap(arr, index, upperBoundIndex);
        Arrays.sort(arr, index+1, N, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }

    private static void swap(Integer[] arr, int index, int upperBoundIndex) {
        int tmp = arr[index];
        arr[index] = arr[upperBoundIndex];
        arr[upperBoundIndex] = tmp;
    }


}