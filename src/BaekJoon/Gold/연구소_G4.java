package BaekJoon.Gold;


import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_G4 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] map, virusArea;
    static int N,M;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    static int maxSafeArea = 0;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j < M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽세우기 (모든 경우의 수)
        DFS(0);

        System.out.println(maxSafeArea);
    }

    private static void DFS(int count) {
        if(count == 3){
            BFS();
            return;
        }
        for(int i=0;i < N;i++){
            for(int j=0;j < M;j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    DFS(count+1);
                    map[i][j] = 0;  // 백 트래킹
                }
            }
        }
    }

    private static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        virusArea = new int[N][M];
        // map 복제후 virusArea의 바이러스 위치를 queue에 저장
        for(int i=0;i < N;i++){
            for(int j=0;j < M;j++){
                virusArea[i][j] = map[i][j];
                if(virusArea[i][j] == 2){
                    queue.add(new int[] {i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            for(int i=0;i < 4;i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                if(mx < 0 || my < 0 || mx == M || my == N){
                    continue;
                }
                if(virusArea[my][mx] == 1 || virusArea[my][mx] == 2){
                    continue;
                }
                if(virusArea[my][mx] == 0){
                    queue.add(new int[]{my,mx});
                    virusArea[my][mx] = 2;
                }
            }
        }

        int count = 0;
        for(int i=0;i < N;i++){
            for(int j=0;j < M;j++){
                if(virusArea[i][j] == 0){
                    count++;
                }
            }
        }
        if(maxSafeArea < count){
            maxSafeArea = count;
        }

    }

}
