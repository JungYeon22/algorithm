package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_2_3더하기_S3 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i < N;i++){
            int num = Integer.parseInt(br.readLine());
            dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int j=4;j <= num;j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            System.out.println(dp[num]);
        }
    }
}

