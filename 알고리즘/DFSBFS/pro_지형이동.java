 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-02
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/62050
  *
  */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] copyLand;
    private static int index;
    
    public int solution(int[][] land, int height) {
            copyLand = new int[land.length][land[0].length];
        index = -1;
        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                if (copyLand[i][j] >= 0) {
                    copyLand[i][j] = index;
                    dfs(i, j, height, land);
                    index--;
                }
            }
        }

        List<Node> list = new ArrayList<>();
        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                for (int k=0; k<4; k++) {
                    int newY = i + dy[k];
                    int newX = j + dx[k];

                    if (newX < 0 || newX >= land[0].length || newY < 0 || newY >= land.length) continue;

                    int dist = Math.abs(copyLand[i][j] - copyLand[newY][newX]);
                    if (dist == 0) continue;
                    list.add(new Node(-copyLand[i][j], -copyLand[newY][newX], Math.abs(land[i][j] - land[newY][newX])));
                }
            }
        }

        Collections.sort(list, (o1, o2) -> o1.dist - o2.dist);
        
        int[] find = new int[-(index-1)];
        for (int i=1; i<find.length; i++) {
            find[i] = i;
        }

        int count = 0;
        int answer = 0;
        for (int i=0; i<list.size(); i++) {
            Node node = list.get(i);
            int a = node.y;
            int b = node.x;
            if (a == b) continue;
            if (findParent(find, a, b) == 0) {
                union(find, a, b);
                count++;
                answer += node.dist;
            }
            if (count == -(index + 1)) break;
        }

        return answer;
    }

    private static void union(int[] find, int a, int b) {
        a = getParent(find, a);
        b = getParent(find, b);

        if (a > b) find[a] = b;
        else find[b] = a;
    }

    private static int findParent(int[] find, int a, int b) {
        a = getParent(find, a);
        b = getParent(find, b);

        if (a == b) return 1;
        return 0;
    }

    private static int getParent(int[] find, int a) {
        if (find[a] == a) return a;
        return getParent(find, find[a]);
    }

    private static void dfs(int y, int x, int height, int[][] land) {
        int num = land[y][x];

        for (int i=0; i<4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (newX < 0 || newX >= land[0].length || newY < 0 || newY >= land.length) continue;
            if (Math.abs(land[newY][newX] - num) > height) continue;
            if (copyLand[newY][newX] < 0) continue;

            copyLand[newY][newX] = index;
            dfs(newY, newX, height, land);
        }
    }
}

class Node {
    int x;
    int y;
    int dist;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}