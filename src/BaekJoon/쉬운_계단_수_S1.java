package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운_계단_수_S1 {
    static BufferedReader br;
    static int N;
    static Long[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Long[N+1][10];
        for(int i=0;i < 10;i++){
            dp[1][i] = 1L;
        }

        long result =0L;
        for(int i=1;i < 10;i++){
            result += DP(N,i);
        }
        System.out.println(result % 1000000000);
    }

    private static long DP(int now, int num) {
        if(now == 1){
            return dp[now][num];
        }
        if(dp[now][num] == null){
            if(num == 0) {
                dp[now][num] = DP(now-1, 1);
            }
            else if(num == 9){
                dp[now][num] = DP(now-1, 8);
            }else {
                dp[now][num] = DP(now-1, num-1) + DP(now-1, num+1);
            }
        }
        return dp[now][num] % 1000000000;
    }

}
