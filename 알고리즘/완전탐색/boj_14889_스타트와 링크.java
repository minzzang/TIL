 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-09	
  * URL   : https://www.acmicpc.net/problem/14889
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] arr;
    private static int N, MIN = Integer.MAX_VALUE;
    private static boolean[] visited;
    private static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(MIN);

    }

    private static void dfs(int index, int depth) {
        if (depth == N / 2) {
            calculateTeamValue();
            return;
        }

        for (int i = index; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }

    private static void calculateTeamValue() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += (arr[i][j] + arr[j][i]);
                } else if (!visited[i] && !visited[j]){
                    linkTeam += (arr[i][j] + arr[j][i]);
                }
            }
        }
        MIN = Math.min(MIN, Math.abs(startTeam - linkTeam));
        if (MIN == 0) {
            System.out.println(0);
            System.exit(0);
        }
    }

}