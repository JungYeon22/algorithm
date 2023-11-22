package BaekJoon;

import java.io.*;
import java.util.*;

public class RGB거리_S1 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] color;
    static int minResult, N;
    static  int[][] sum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new int[3][N];
        sum = new int[3][N];
        minResult = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            color[0][i] = Integer.parseInt(st.nextToken());
            color[1][i] = Integer.parseInt(st.nextToken());
            color[2][i] = Integer.parseInt(st.nextToken());
            minResult += color[(i+1) % 3][i];
        }

        sum[0][0] = color[0][0];
        sum[1][0] = color[1][0];
        sum[2][0] = color[2][0];

        // solution 2
        System.out.println(Math.min(solution2(0,N-1),Math.min(solution2(1,N-1),solution2(2,N-1))));


        //solution 1
        for (int i = 0; i < 3; i++) {
            solution(i, 0, 0);
        }
        System.out.println(minResult);
    }

    private static int solution2(int colorNum,int homeNum) {
        if(sum[colorNum][homeNum] == 0){
            if(colorNum == 0){
                sum[colorNum][homeNum] = Math.min(solution2(1,homeNum-1), solution2(2,homeNum-1)) + color[0][homeNum];
            }
            if(colorNum == 1){
                sum[colorNum][homeNum] = Math.min(solution2(0,homeNum-1), solution2(2,homeNum-1)) + color[1][homeNum];
            }
            if(colorNum == 2){
                sum[colorNum][homeNum] = Math.min(solution2(1,homeNum-1), solution2(0,homeNum-1)) + color[2][homeNum];
            }
        }

        return sum[colorNum][homeNum];
    }

    private static void solution(int colorNum, int homeNum, int sum) {

        if (homeNum >= N) {
            if (minResult > sum) {
                minResult = sum;
            }
            return;
        }
        if(minResult < sum){
            return;
        }
        solution((colorNum + 1) % 3, homeNum + 1, sum + color[colorNum][homeNum]);
        solution((colorNum + 2) % 3, homeNum + 1, sum + color[colorNum][homeNum]);
    }
}
