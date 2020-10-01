 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-01
  * URL   : https://www.acmicpc.net/problem/11727
  *
  */
import java.util.*;

//bottom-up 방식

public class Main {
	public static void main(String[] args)	{
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n+2];
		
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]*2) % 10007;
		}
		
		System.out.println(dp[n]);
	
}
}

