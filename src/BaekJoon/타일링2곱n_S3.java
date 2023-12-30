package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일링2곱n_S3 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[1001];
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(DP(N));

    }

    private static int DP(int n) {
        // 점화식 dp(i) = dp(i-1) + dp(i-2)

        if(dp[n] == null){
            dp[n] = (DP(n-1) + DP(n-2))%10007;
        }
        return dp[n];
    }
}
