package BaekJoon;

import java.io.*;
import java.util.*;
public class 연구소2_G4 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] map;
    static int N,M,MaxSafeArea;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        MaxSafeArea = 0;
        for(int i=0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j < M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 벽 3개를 고르기
        DFS(0,0,0); // 처음 위치 y, x ,count(벽 몇개 세웠는지)
        System.out.println(MaxSafeArea);

    }

    private static void DFS(int y, int x, int count) {
        if(count == 3){
            BFS();
            return;
        }
        for(int i=0;i < N;i++){
            for(int j=0;j < M;j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    DFS(i,j,count+1);
                    map[i][j] = 0;
                }
            }

        }

    }

    private static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        // map 복사
        int[][] virusMap = new int[N][M];
        for(int i=0;i < N;i++){
            for(int j=0;j < M;j++){
                virusMap[i][j] = map[i][j];
            }
        }
        // 바이러스 위치 queue에 넣기
        for(int i=0;i < N;i++){
            for(int j=0;j < M;j++){
                if(virusMap[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] virus = queue.poll();
            for(int i=0;i < 4;i++){
                int mx = virus[1] + dx[i];
                int my = virus[0] + dy[i];
                if(mx < 0 || my < 0 || mx >= M || my >= N){
                    continue;
                }
                if(virusMap[my][mx] == 0){
                    queue.add(new int[]{my,mx});
                    virusMap[my][mx] = 2;
                }
            }
        }
        int count =0;
        for(int i=0;i < N;i++){
            for(int j=0;j < M;j++){
                if(virusMap[i][j] == 0){
                    count++;
                }
            }
        }
        MaxSafeArea = Math.max(MaxSafeArea,count);
    }
}
