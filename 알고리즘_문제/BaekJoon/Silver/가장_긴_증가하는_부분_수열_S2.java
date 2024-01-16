package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장_긴_증가하는_부분_수열_S2 {
    static int[] arr;
    static int[] dp;
    static int max, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i=0;i < N;i++){
            arr[i] = Integer.parseInt(split[i]);
        }

        for(int i=0;i < N;i++){
            dp[i] = 1;
            for(int j=0;j < i;j++){
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for(int data : dp){
            if(max < data) max = data;
        }
        System.out.println(max);

    }

}
