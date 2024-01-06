package BaekJoon.Gold;

import java.io.*;
import java.util.*;

public class 내리막길_G3 {
    static int[][] map;
    static int[][] dp;
    static final int[] dx = {1, -1, 0,0};
    static final int[] dy = {0, 0, 1,-1};
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());   // y 축
        N = Integer.parseInt(st.nextToken());   // x 축
        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                dp[i][j] = -1;
            }
        }
        System.out.println(DFS(0,0));
        for(int i=0;i < M;i++){
            for(int j=0;j < N;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int DFS(int x, int y) {
        if(x == N-1 && y == M-1){
            return 1;
        }
        if(dp[y][x] != -1){
            return dp[y][x];
        }
        dp[y][x] = 0;
        for(int i=0;i < 4;i++){
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx < 0 || my < 0 || mx == N || my == M){
                continue;
            }
            if(map[my][mx] < map[y][x]){
                dp[y][x] += DFS(mx,my);
            }
        }
        return dp[y][x];
    }
}
