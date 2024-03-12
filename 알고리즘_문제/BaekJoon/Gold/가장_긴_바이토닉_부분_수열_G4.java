package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_긴_바이토닉_부분_수열_G4 {
    static int N;
    static int[] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        seq = new int[N];
        for(int i=0;i < N;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int max =0;
        for(int i=0;i < N;i++){
            int front = LIS1(i);    // 앞
            int back = LIS2(i);    // 뒤
            max = Math.max(max, front + back);
        }

        System.out.println(max);
    }

    private static int LIS2(int num) {
        int[] dp = new int[N];
        for(int i=num;i < N;i++){
            dp[i] = 1;
            for(int j=num;j < i;j++){
                if(seq[j] > seq[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i=num;i < N;i++){
            max = Math.max(dp[i], max);
        }
        return max;
    }

    private static int LIS1(int num) {
        int[] dp = new int[N];

        for(int i=0;i < num;i++){
            if(seq[num] == seq[i]) continue;
            dp[i] = 1;
            for(int j=0;j < i;j++){
                if(seq[num] == seq[i]) continue;
                if(seq[j] < seq[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i=0;i < num;i++){
            max = Math.max(dp[i], max);
        }
        if(num > 0 && seq[num] == seq[num-1]){
            max -= 1;
        }
        return max;
    }
}
