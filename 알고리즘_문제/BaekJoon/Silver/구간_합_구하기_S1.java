package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] sum = new int[N+1][N+1];
        for(int i=1;i <= N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j <= N;j++){
                sum[i][j] = sum[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());//시작 행
            int startColum = Integer.parseInt(st.nextToken());//시작 열
            int endRow = Integer.parseInt(st.nextToken());//종료 행
            int endColum = Integer.parseInt(st.nextToken());//종료 열
            int result = 0;
            for(int j=startRow;j <= endRow;j++){
                result += (sum[j][endColum] - sum[j][startColum-1]);
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);


    }
}
