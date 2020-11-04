 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-04
  * URL   : https://www.acmicpc.net/problem/14226
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[N+1][N+1];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.length == N) {
                System.out.println(node.count);
                break;
            }

            queue.offer(new Node(node.length, node.length, node.count+1));

            if (node.buffer != 0 && node.length + node.buffer < N+1 && !visited[node.length + node.buffer][node.buffer]) {
                visited[node.length + node.buffer][node.buffer] = true;
                queue.offer(new Node(node.length + node.buffer, node.buffer, node.count+1));
            }

            if (node.length > 0 && node.length < N+2 && !visited[node.length - 1][node.buffer]) {
                visited[node.length - 1][node.buffer] = true;
                queue.offer(new Node(node.length - 1, node.buffer, node.count+1));
            }
        }

    }

}

class Node {
    int length;
    int buffer;
    int count;

    Node(int length, int buffer, int count) {
        this.length = length;
        this.buffer = buffer;
        this.count = count;
    }
}