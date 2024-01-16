package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주_시식_S1 {
    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[10001];
        dp = new Integer[10001];
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
        }
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max((Math.max(arr[1]+arr[2], arr[1]+arr[3])), arr[2] + arr[3]);
        int dp1 = DP(N);
        System.out.println(dp1);

    }

    private static int DP(int n) {
        if(dp[n] == null){
            int max = Math.max(DP(n - 1), Math.max(DP(n - 2) + arr[n], DP(n - 3) + arr[n - 1] + arr[n]));
            dp[n] = max;
        }
        return dp[n];
    }


}
/*


dp(n) = dp(n-1) + arr(n)
==> 세번 연속으로 마실 수 없음!! => 2번 연속까지 가능
dp(n) = dp(

6
6
10
13
9
8
1
 */
