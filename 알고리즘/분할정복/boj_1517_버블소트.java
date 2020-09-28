 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-28
  * URL   : https://www.acmicpc.net/problem/1517
  *
  */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static StringBuffer sb = new StringBuffer();
    private static int[] arr;
    private static int[] answer;
    private static long count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N-1);

        System.out.println(count);
    }

    private static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid+1, right);
            merge(left, right);
        }
    }

    private static void merge(int left, int right) {

        int mid = (left + right) / 2;
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {

            if (arr[i] > arr[j]) {
                answer[k++] = arr[j++];
                count += mid-i+1;
            } else {
                answer[k++] = arr[i++];
            }
        }

        while (j <= right) {
            answer[k++] = arr[j++];
        }
        while (i <= mid) {
            answer[k++] = arr[i++];
        }
        
        for (int n=left; n<=right; n++) {
            arr[n] = answer[n];
        }
    }
}