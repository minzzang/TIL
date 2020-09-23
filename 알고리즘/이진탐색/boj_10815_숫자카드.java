 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-23
  * URL   : https://www.acmicpc.net/problem/10815
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
        }

        int M = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        st = new StringTokenizer(br.readLine());
        Arrays.sort(arr);
        int count = 0;
        for (int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (binarySearch(arr, target)) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);

    }

    private static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int m = arr[mid];

            if (m > target) {
                right = mid - 1;
            } else if (m < target) {
                left = mid + 1;
            } else {
                return true;
            }

        }
        return false;
    }
}