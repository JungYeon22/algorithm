package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한_배낭_G5 {
    static Integer[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int maxValue = Integer.parseInt(st.nextToken());
        dp = new Integer[N][maxValue+1];
        arr = new int[N][2];
        for(int i=0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   // 무게
            arr[i][1] = Integer.parseInt(st.nextToken());   // 가치
        }
        int dp1 = DP(N-1, maxValue);
        System.out.println(dp1);


    }

    private static int DP(int n, int m) {
        if(n < 0) return 0;
        if(dp[n][m]==null){
            if(arr[n][0] > m){
                dp[n][m] = DP(n-1,m);
            }
            else{
                dp[n][m] = Math.max(DP(n-1,m), DP(n-1, m-arr[n][0]) + arr[n][1]);
            }
        }
        return dp[n][m];
    }
}