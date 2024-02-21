package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림_S1 {
    static boolean[][] visited;
    static int[] dx = {0, 0 ,1, -1};
    static int[] dy = {1, -1 , 0, 0};
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());    //세로 크리
        M = Integer.parseInt(st.nextToken());    // 가로 크기
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j < M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count =0;   // 그림개수
        int maxValue = 0;
        for(int i=0;i< N;i++){
            for(int j=0;j < M;j++){
                if(!visited[i][j] && map[i][j]==1){
                    int value = BFS(i, j);
                    count++;
                    maxValue = Math.max(maxValue, value);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxValue);
    }

    private static int BFS(int num1, int num2) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {num1, num2});
        visited[num1][num2] = true;
        int value = 1;
        while (!q.isEmpty()){
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            for(int i=0;i < 4;i++){
                int my = dy[i] + y;
                int mx = dx[i] + x;

                if(mx < 0 || my < 0 || mx >= M || my >= N){
                    continue;
                }
                if(!visited[my][mx] && map[my][mx] == 1){
                    visited[my][mx] = true;
                    q.add(new int[] {my,mx});
                    value++;
                }
            }
        }
        return value;
    }
}
