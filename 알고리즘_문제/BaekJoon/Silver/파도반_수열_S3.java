package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반_수열_S3 {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        for(int i=0;i < T;i++){
            int N = Integer.parseInt(br.readLine());
            // 점화식 dp(i) = dp(i-3)+dp(i-2)
            if(dp[N] == 0) {
                for (int j = 5; j <= N; j++) {
                    dp[j] = dp[j - 2] + dp[j - 3];
                }
            }
            System.out.println(dp[N]);
        }

    }
}
