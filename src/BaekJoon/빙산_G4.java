package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
입력 :  N과 M은 3 이상 300 이하 / 각 칸에 들어가는 값은 0 이상 10 이하 / 1 이상의 정수가 들어가는 칸의 개수는 10,000 개 이하
시간 복잡도 : O(n + e)
for문으로 전체를 돌다가 빙산이 보이면 DFS or BFS
BFS로 각 빙산주변(위,아래,왼,오) 바닷물 확인후 계산
문제 상황 : 계산되어 바닷물이된 빙산이 옆 빙산 계산시 영향이 간다. -> visited배열로 방문한 빙산은 바닷물로 계산 x
 */
public class 빙산_G4 {
    static BufferedReader br;
    static StringTokenizer st;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    static int[][] map;
    static boolean[][] visited;
    static int N,M;
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
        int time = 0;
        while(true){
            int count= countIsland();
            if(count > 1) break;
            else if(count == 0){
                time = 0;
                break;
            }
            BFS();
            time++;


        }
        System.out.println(time);
    }

    private static int countIsland() {
        visited = new boolean[N][M];
        int count =0;
        for(int i=0;i < N;i++){
            for(int j=0;j < M;j++){
                if(map[i][j] > 0 && !visited[i][j]){
                    DFS(i,j,visited);
                    count++;
                }

            }
        }
        return count;
    }

    private static void DFS(int y, int x, boolean[][] visited) {
        visited[y][x] = true;
        for(int i=0;i < 4;i++){
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx < 0 || my < 0 || mx >= M || my >= N) continue;
            if(map[my][mx] > 0 && !visited[my][mx]){
                DFS(my,mx,visited);
            }
        }
    }

    private static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][M];
        for(int i=0;i < N;i++){
            for(int j=0;j < M;j++){
                if(map[i][j] > 0){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int sea = 0;
            for(int i=0;i < 4;i++){
                int mx = now[1] + dx[i];
                int my = now[0] + dy[i];
                if(mx < 0 || my < 0 || mx >= M || my >= N) continue;
                if(map[my][mx] == 0 && !visited[my][mx]){
                    sea++;
                }
            }
            map[now[0]][now[1]] -= sea;
            if(map[now[0]][now[1]] < 0){
                map[now[0]][now[1]] = 0;
            }

        }

    }
}
