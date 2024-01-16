package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_삼각형_S1 {
    static int[][] arr,dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new int[N][N];
        StringTokenizer st;

        for(int i=0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j <= i;j++){
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;
            }
        }
        int max = 0;
        for(int i=0;i < N;i++){
            DP(N-1, i);
        }
        for(int i=0;i < N;i++){
            int num = dp[N - 1][i];
            max = Math.max(num, max);
        }
        System.out.println(max);
    }

    private static int DP(int n, int r) {
        if(n==0 && r==0) {
            dp[n][r] = arr[0][0];
            return dp[n][r];
        }
        if(dp[r][n] == 0){
            if(r == 0){
                dp[n][r] = DP(n-1, r) + arr[n][r];
            }
            if(r == n){
                dp[n][r] = DP(n-1,r-1) + arr[n][r];
            }
            if(dp[n][r] == 0){
                dp[n][r] = Math.max(DP(n-1, r-1), DP(n-1, r)) + arr[n][r];
            }
        }
        return dp[n][r];
    }
}
