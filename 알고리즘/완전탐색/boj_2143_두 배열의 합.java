 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-01-25	
  * URL   : https://www.acmicpc.net/problem/2143
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> mapA = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                mapA.put(sum, mapA.getOrDefault(sum, 0) + 1);
            }
        }

        long answer = 0;
        for (int i = 0; i < M; i++) {
            sum = 0;
            for (int j = i; j < M; j++) {
                sum += B[j];
                if (mapA.containsKey(T - sum)) {
                    answer += mapA.get(T - sum);
                }

            }
        }

        System.out.println(answer);
    }
}

