package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_큰_증가하는_부분_수열_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        for(int i=0;i < N;i++){
            int num = Integer.parseInt(st.nextToken());
            input[i] = num;
        }

        int[][] arr = new int[N][N];
        arr[0][0] = input[0];
        // 첫 줄 셋팅
        for(int i=0;i < N;i++){
            if(input[0] < input[i]){
                arr[0][i] = input[0] + input[i];
            }else {
                arr[0][i] = input[i];
            }
        }

        for(int i=1;i < N;i++){
            for(int j=0;j < N;j++){
                if(j <= i){
                    arr[i][j] = arr[i-1][j];
                    continue;
                }
                if(input[i] < input[j]){
                    arr[i][j] = Math.max((arr[i][i] + input[j]), arr[i-1][j]);
                }else{
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        int max=0;
        for(int i=0;i < N;i++){
            max = Math.max(arr[N-1][i], max);
        }
        System.out.println(max);

        for(int i=0;i < N;i++){
            for(int j=0;j < N;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
/*
가장 큰 증가하는 부분 수열

    1,  100,  2,  50,  60,  3,  5,  6,  7,  8
    1
    1   101   3   51   61   4   6   7   8   9
    1   101   . ...
    1   101   3   53   63   6   8   9   10  11
    1   101   3   53   113  ...
    1   101   3   53   113

 */
