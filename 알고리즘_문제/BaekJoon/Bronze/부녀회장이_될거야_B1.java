package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이_될거야_B1 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            dp = new int[K+1][N+1];
            int result = DP(K, N);
            System.out.println(result);
        }
    }

    private static int DP(int k, int n) {
        if(n == 1){
            dp[k][n] = 1;
        }
        if(k == 0){
            dp[k][n] = n;
        }
        if(dp[k][n] == 0){
            dp[k][n] = DP(k, n-1) + DP(k-1, n);
        }
        return dp[k][n];
    }
}
/*
점화식 dp[k][n] = dp[k][n-1] + dp[k-1][n]

 1 3 6 10  15
 1 2 3 4   5   6   7     8    9
 */
