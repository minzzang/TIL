 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-17
  * URL   : https://www.acmicpc.net/problem/1167
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] visited;

    private static int sum;

    private static int vertext;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        List<List<Node>> list = new ArrayList<>();
        visited = new boolean[V];

        for (int i=0; i<V; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i=0; i<V; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int child = 0;
            while ((child=Integer.parseInt(st.nextToken())) != -1) {
                int dist = Integer.parseInt(st.nextToken());

                list.get(index).add(new Node(child-1, dist));
            }
        }

        dfs(list, 0, 0);
        sum = 0;
        dfs(list, vertext, 0);
        System.out.println(sum);

    }

    private static void dfs(List<List<Node>> list, int v, int dist) {
        visited[v] = true;

        for (Node n : list.get(v)) {
            if (visited[n.getNode()]) continue;
            dfs(list, n.getNode(), dist + n.getDist());
        }

        if (sum < dist) {
            sum = dist;
            vertext = v;
        }
        visited[v] = false;
    }
}

class Node {
    private int node;
    private int dist;

    Node(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    public int getNode() {
        return this.node;
    }

    public int getDist() {
        return this.dist;
    }

    @Override
    public String toString() {
        return "Node{" +
                "node=" + node +
                ", dist=" + dist +
                '}';
    }
}