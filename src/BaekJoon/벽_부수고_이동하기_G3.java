package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 벽_부수고_이동하기_G3 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    static class Loc {
        int x, y, count;
        boolean destroy;

        public Loc(int x, int y, int count, boolean destroy) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.destroy = destroy;
        }
    }


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // y축
        M = Integer.parseInt(st.nextToken());   // x축
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                int value = input.charAt(j) - '0';
                map[i][j] = value;
            }
        }
        BFS();

    }

    private static void BFS() {
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(0, 0, 1, false));
        boolean visited[][][] = new boolean[N][M][2];
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            Loc now = queue.poll();
            int x = now.x;
            int y = now.y;
            if(x == M-1 && y == N-1){
                System.out.println(now.count);      //제일 먼저 도착하는 queue가 최소경로
                return;
            }
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx < 0 || my < 0 || mx >= M || my >= N) {
                    continue;
                }
                if (map[my][mx] == 0) {   //벽이 아니면
                    if (!now.destroy && !visited[my][mx][0]) {
                        queue.add(new Loc(mx, my, now.count + 1,false));
                        visited[my][mx][0] = true;
                    }
                    if(now.destroy && !visited[my][mx][1]){
                        queue.add(new Loc(mx,my,now.count + 1, true));
                        visited[my][mx][1] = true;
                    }
                }
                if(map[my][mx] == 1){
                    if(!now.destroy && !visited[my][mx][1]){
                        queue.add(new Loc(mx,my,now.count + 1,true));
                        visited[my][mx][1]= true;
                    }
                }

            }
        }
        System.out.println(-1);
        return;
    }

}
