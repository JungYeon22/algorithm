package BaekJoon.Silver;

import java.util.Scanner;

public class _01타일_S3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] dp = new long[N+1];
        dp[1] = 1;
        if(N > 1){
            dp[2] = 2;
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%15746;
        }
        System.out.println(dp[N]);

    }
}
/*
N
1 :  1
2 :  11, 00
3 :  111, 100, 001
4 :  1111-, 1100--, 1001-, 0011-, 0000--
5 :  11111, 11100, 11001, 10011, 00111, 10000, 00100, 00001

N자리 값은 이전 값에서 1이 붙은 값 + 2번째 전에서 00이 붙은 값
 */
