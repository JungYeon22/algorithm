package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구_이동_G4 {
    static  boolean[][] visited;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N, L, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());    // N개의 행열
        L = Integer.parseInt(st.nextToken());    // 인구수가 L ~ R 사이의 값이여야 국경선 오픈
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j < N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while(true){
            int exist = 0;
            visited = new boolean[N][N];
            for(int i=0;i < N;i++){
                for(int j=0;j < N;j++){
                    if(!visited[i][j]){
                        if(BFS(i, j)) exist++;
                    }
                }
            }
            if(exist == 0) break;
            day++;
        }
        System.out.println(day);
    }

    private static boolean BFS(int i, int j) {
        Queue<int[]> searchQ = new LinkedList<>();
        Queue<int[]> saveQ = new LinkedList<>();
        searchQ.add(new int[] {i, j});
        saveQ.add(new int[] {i, j});
        visited[i][j] = true;
        boolean isExist = false;
        int sum = map[i][j];
        while(!searchQ.isEmpty()){
            int[] poll = searchQ.poll();
            for(int k=0;k < 4;k++){
                int mx = poll[1] + dx[k];
                int my = poll[0] + dy[k];

                if(mx < 0 || my < 0 || mx >= N || my >= N) continue;

                int diff = Math.abs(map[my][mx] - map[poll[0]][poll[1]]);
                if(!visited[my][mx] && diff >= L && diff <= R){
                    searchQ.add(new int[]{my,mx});
                    saveQ.add(new int[]{my,mx});
                    visited[my][mx] = true;
                    sum += map[my][mx];
                    isExist = true;
                }
            }
        }
        int avg = sum / saveQ.size();
        while(!saveQ.isEmpty()){
            int[] poll = saveQ.poll();
            map[poll[0]][poll[1]] = avg;
        }
        return isExist;

    }
}
