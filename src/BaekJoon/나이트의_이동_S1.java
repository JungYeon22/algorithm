package BaekJoon;

import javax.xml.stream.events.StartDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의_이동_S1 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] now,target;
    static int[][] visited;
    static final int[] dx = {1,1,-1,-1,2,2,-2,-2};
    static final int[] dy = {2,-2,2,-2,1,-1,1,-1};
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            visited = new int[N][N];
            st = new StringTokenizer(br.readLine());
            now = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            target = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            int bfs = BFS();
            System.out.println(bfs);
        }
    }

    private static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(now);
        visited[now[0]][now[1]] = 0;
        if(target[0] ==now[0] && target[1] == now[1]) {
            return 0;
        }
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[1];
            int y = poll[0];
            for(int i=0;i < 8;i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                if(mx < 0 || my < 0 || mx >= N || my >= N){
                    continue;
                }
                if(visited[my][mx] == 0){
                    queue.add(new int[] {my,mx});
                    visited[my][mx] = visited[y][x] + 1;
                    if(target[0] == my && target[1] == mx){
                        return visited[my][mx];
                    }
                }

            }
        }
        return 0;
    }
}
