package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_1_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 동전의 개수
        int targetNum = Integer.parseInt(st.nextToken());   // 목표 금액

        int[] dp = new int[targetNum+1];    // 각 금액마다 경우의 수를 더한다.
        int[] coin = new int[N];    // 코인의 값 배열
        for(int i=0;i < N;i++){
            int num = Integer.parseInt(br.readLine());
            coin[i] = num;
        }
        dp[0] = 1;
        // 점화식 dp[n] = dp[n] + dp[n - coin[i]]
        for(int i=0;i < N;i++){
            for(int j=0;j <= targetNum;j++){
                if(coin[i] <= j){
                    dp[j] = dp[j] + dp[j - coin[i]];
                }
            }
        }
        System.out.println(dp[targetNum]);

    }
}
