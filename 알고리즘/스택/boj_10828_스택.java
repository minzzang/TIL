 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-14
  * URL   : https://www.acmicpc.net/problem/10828
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        for (int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            if ("push".equals(type)) {
                int n = Integer.parseInt(st.nextToken());
                stack.push(n);
            } else if ("pop".equals(type)) {
                sb.append(stack.size() == 0 ? -1 +"\n" : stack.pop() +"\n");
            } else if ("size".equals(type)) {
                sb.append(stack.size() + "\n");
            } else if ("empty".equals(type)) {
                sb.append(stack.size() == 0 ? 1 +"\n" : 0 +"\n");
            } else if ("top".equals(type)) {
                sb.append(stack.size() == 0 ? -1 +"\n": stack.peek() +"\n") ;
            }
        }

        System.out.println(sb);
    }

}

            right++;
        }

        return left == right;

    }
}

/////////// 2차 코드
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> stack = new Stack<>();
        
        int N = sc.nextInt();

        for (int i=0; i<N; i++) {

            String s = sc.next();
            stack.clear();
            if (isVPS(s, stack)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    private static boolean isVPS(String s, Stack stack) {

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch== '(') {
                stack.push(ch);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            stack.pop();
        }

        if (stack.empty()) {
            return true;
        }
        return false;

    }
}
