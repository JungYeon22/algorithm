package BaekJoon;

import java.io.*;
import java.util.*;
public class 토마토_G5 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] boxes;
    static int[][] visited;
    static int M,N,count;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        boxes = new int[N][M];
        visited = new int[N][M];
        int total = 0;
        for(int i=0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j < M;j++){
                boxes[i][j] = Integer.parseInt(st.nextToken());
                if(boxes[i][j] != -1) {
                    total++;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i < N;i++){
            for(int j=0;j < M;j++){
                if(boxes[i][j] == 1){
                    queue.add(new int[]{i,j});
                    visited[i][j] = 0;
                }
            }
        }
        int bfs = BFS(queue, total);
        if(total > count){
            System.out.println(-1);
        }
        else {
            System.out.println(bfs);
        }
    }
    private static int BFS(Queue<int[]> queue,int total) {     // y는 세로(N) / x는 가로(M)
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        count = 0;
        int maxDay = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            count++;
            int y = now[0];
            int x = now[1];
            for(int i=0;i < 4;i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                if(mx < 0 || my < 0 || mx == M || my == N){
                    continue;
                }
                if(boxes[my][mx] == -1 || boxes[my][mx] == 1){
                    continue;
                }
                if(visited[my][mx] == 0 && boxes[my][mx] == 0){
                    queue.add(new int[]{my,mx});
                    visited[my][mx] = visited[y][x] + 1;
                    if(maxDay < visited[my][mx]){
                        maxDay = visited[my][mx];
                    }
                }
            }
        }
        return maxDay;

    }
}
