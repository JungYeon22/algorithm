package BaekJoon.Gold;

import java.io.*;
import java.util.*;

public class 아기상어_G3 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] sea;
    static LinkedList<int[]>[] fish;
    static int N;
    static final int[] dx = {0,-1,1,0};
    static final int[] dy = {-1,0,0,1};

    static class Shark {
        private int x, y, count, size, eatingFishes;

        public Shark(int x, int y, int count, int size, int eatingFishes) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.size = size;
            this.eatingFishes = eatingFishes;
        }

    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sea = new int[N][N];
        fish = new LinkedList[7];
        for (int i = 0; i <= 6; i++) {
            fish[i] = new LinkedList<>();
        }
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                sea[i][j] = value;
                if (value > 0 && value <= 6) {
                    fish[value].add(new int[]{i, j});
                }
                if (value == 9) {
                    start[0] = i;
                    start[1] = j;
                    sea[i][j] = 0;
                }
            }
        }
        int count = 0,size =2,eatingFishes=0;
        while(true){
            Shark bfs = BFS(start,count, size,eatingFishes);
            if(bfs.count == -1){
                break;
            }
            start[0] = bfs.y;
            start[1] = bfs.x;
            count = bfs.count;
            size = bfs.size;
            eatingFishes = bfs.eatingFishes;
            System.out.println("bfs result : " + bfs.x + " " + bfs.y + " " + count);
        }
        System.out.println(count);


    }

    private static Shark BFS(int[] start,int start_count, int start_size, int start_eatingFishes) {
        Queue<Shark> queue = new LinkedList<>();
        queue.add(new Shark(start[1], start[0], start_count, start_size, start_eatingFishes));
        boolean[][] visited = new boolean[N][N];
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            Shark shark = queue.poll();
            System.out.println("poll : " + shark.x + " " + shark.y);
            if (sea[shark.y][shark.x] != 0 && sea[shark.y][shark.x] < shark.size) {
                int size = shark.size;
                int eatingFish = shark.eatingFishes;
                eatingFish++;
                if(eatingFish == size){
                    size++;
                    eatingFish = 0;
                }
                sea[shark.y][shark.x] = 0;

                return new Shark(shark.x, shark.y, shark.count, size, eatingFish);
            }
            for (int i = 0; i < 4; i++) {
                int mx = shark.x + dx[i];
                int my = shark.y + dy[i];
                if (mx < 0 || my < 0 || mx >= N || my >= N) {
                    continue;
                }
                if (!visited[my][mx]) {
                    queue.add(new Shark(mx, my, shark.count + 1, shark.size, shark.eatingFishes));
                    //System.out.println("add : " + mx + " " + my);
                    visited[my][mx] = true;
                }
            }
        }
        return new Shark(-1,-1,-1,-1,-1);

    }

}
