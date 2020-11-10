 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-10
  * URL   : https://www.acmicpc.net/problem/1753
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(br.readLine());

        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= U; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, d));
        }

        int[] dist = new int[U+1];
        boolean[] visited = new boolean[U+1];
        for (int i = 1; i < dist.length; i++) {
            if (i == startV) {
                dist[i] = 0;
                continue;
            }
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        queue.offer(new Node(startV, 0));

        while (!queue.isEmpty()) {
            Node start = queue.poll();
            visited[start.vertex] = true;

            for (Node node : list.get(start.vertex)) {
                if (dist[node.vertex] > dist[start.vertex] + node.dist) {
                    dist[node.vertex] = dist[start.vertex] + node.dist;
                    queue.offer(new Node(node.vertex, dist[node.vertex]));
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
}

static class Node {
    int vertex;
    int dist;

    Node(int vertex, int dist) {
        this.vertex = vertex;
        this.dist = dist;
    }
}

}
