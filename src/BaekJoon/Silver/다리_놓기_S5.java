package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리_놓기_S5 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        dp = new int[30][30];
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(combi(M, N));
        }
    }

    private static int combi(int m, int n) {
        if(dp[m][n] > 0){
            return dp[m][n];
        }
        if(n == m || n == 0){
            return dp[m][n] = 1;
        }
        else dp[m][n] = combi(m-1, n-1) + combi(m-1, n);
        return dp[m][n];

    }
}
