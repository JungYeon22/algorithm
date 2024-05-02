package BaekJoon.Silver;

import java.util.Scanner;

public class 오르막수_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        long[][] dp = new long[N+1][10];
        for(int i=0;i < dp[0].length;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i <= N;i++){
            for(int j=9;j >= 0;j--){
                if(j==9){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j]%10007 + dp[i][j+1]%10007;
            }
        }

        long sum = 0;
        for(int i=0;i < 10;i++){
            sum += dp[N][i];
        }
        System.out.println(sum%10007);

    }
}
/*
        dp[i][j] = dp[i-1][j] ~ dp[i-1][9]의 합
* */
