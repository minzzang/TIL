 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-18
  * URL   : https://www.acmicpc.net/problem/1922
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
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Node node = new Node(u, v, d);
            list.get(u).add(node);
            queue.offer(node);
        }

        int[] parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Node minNode = queue.poll();

            if (find(parent, minNode.u, minNode.v) == 1) {
                union(parent, minNode.u, minNode.v);
                count += minNode.cost;
            }

        }
        System.out.println(count);

    }

    private static int find(int[] parent, int u, int v) {
        int a = getParent(parent, u);
        int b = getParent(parent, v);

        if (a == b) {
            return 0;
        } else {
            return 1;
        }
    }

    private static void union(int[] parent, int u, int v) {
        int a = getParent(parent, u);
        int b = getParent(parent, v);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static int getParent(int[] parent, int vertex) {
        if (parent[vertex] == vertex) {
            return vertex;
        }
        return getParent(parent, parent[vertex]);
    }
}

class Node {
    int u;
    int v;
    int cost;

    Node (int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
}