package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합_S2 {
    static int[] arr;
    static Integer[] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp  = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i < N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        max = arr[0];
        DP(N-1);
        System.out.println(max);
    }

    private static int DP(int n) {
        if(dp[n] == null){
            dp[n] = Math.max(DP(n-1) + arr[n], arr[n]);

            max = Math.max(dp[n], max);
        }
        return dp[n];
    }
}
