package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BabyShark{
    int x,y;
    int size, eatFishCnt, timeCnt;

    public BabyShark(int x, int y, int size, int eatFishCnt, int timeCnt) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.eatFishCnt = eatFishCnt;
        this.timeCnt = timeCnt;
    }
}
public class 아기_상어_G3 {
    static int N;
    static int[][] space;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 2 <= N <= 20
        space = new int[N][N];
        StringTokenizer st;
        int[] startLoc = new int[2];
        for(int i=0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j <N;j++){
                space[i][j] = Integer.parseInt(st.nextToken());
                if(space[i][j] == 9){
                    startLoc[0] = i;
                    startLoc[1] = j;
                }
            }
        }
        int count =0;
        BabyShark babyShark = new BabyShark(startLoc[1], startLoc[0], 2, 0, 0);
        while(true){
            babyShark = BFS(babyShark);
            System.out.println(babyShark.x + " " + babyShark.y);
            System.out.println("size : " + babyShark.size +"/ count : " + babyShark.timeCnt);
            if(babyShark.size == -1){
                break;
            }
            count = babyShark.timeCnt;
        }
        System.out.println(count);

    }

    private static BabyShark BFS(BabyShark babyShark) {
        int[] dx = {0,-1,1,0};
        int[] dy = {-1,0,0,1};
        boolean[][] visited = new boolean[N][N];
        visited[babyShark.y][babyShark.x] = true;
        Queue<BabyShark> queue = new LinkedList<>();
        queue.add(babyShark);
        space[babyShark.y][babyShark.x] = 0;
        while(!queue.isEmpty()){
            BabyShark shark = queue.poll();
            // 먹을 수 있는 물고기를 만남
            if(space[shark.y][shark.x] != 0 && space[shark.y][shark.x] < shark.size){
                //먹음
                int eatFish = shark.eatFishCnt + 1;
                int sharkSize = shark.size;
                space[shark.y][shark.x] = 0;
                // 성장 조건 완료
                if(sharkSize == eatFish){
                    sharkSize++;
                    eatFish = 0;
                }
                return new BabyShark(shark.x, shark.y, sharkSize, eatFish, shark.timeCnt);
            }

            for(int i=0;i < 4;i++){
                int mx = shark.x + dx[i];
                int my = shark.y + dy[i];
                if(mx < 0 || my < 0 || mx >= N || my >= N) continue;
                if(space[my][mx] > shark.size) continue;
                if(!visited[my][mx]){
                    visited[my][mx] = true;
                    queue.add(new BabyShark(mx,my, shark.size, shark.eatFishCnt, shark.timeCnt+1));
                }
            }
        }
        return new BabyShark(-1,-1,-1,-1,-1);


    }

}
