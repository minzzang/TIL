 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-31
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/62050
  *
  */

class Solution {
   public static int solution(int[][] land, int height) {
        int answer = 0;

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

        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                System.out.print(copyLand[i][j] + " ");
            }
            System.out.println();
        }

        int count = -index;
        int[] min = new int[count];
        List<Node> list = new ArrayList<>();
        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                for (int k=0; k<4; k++) {
                    int newY = i + dy[k];
                    int newX = j + dx[k];

                    if (newX < 0 || newX >= land[0].length || newY < 0 || newY >= land.length) continue;

                    int dist = Math.abs(copyLand[i][j] - copyLand[newY][newX]);
                    if (dist == 0) continue;
                    list.add(new Node(newX, newY, dist));
                }
            }
        }

        Collections.sort(list, (o1, o2) -> o1.dist - o2.dist);

        find();

        return answer;
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
