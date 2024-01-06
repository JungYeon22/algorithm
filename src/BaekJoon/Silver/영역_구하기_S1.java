package BaekJoon.Silver;
import java.io.*;
import java.util.*;
public class 영역_구하기_S1 {

    static BufferedReader br;
    static StringTokenizer st;
    static boolean[][] area;
    static int count;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int M,N,K;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());   // y 축
        N = Integer.parseInt(st.nextToken());   // x 축
        K = Integer.parseInt(st.nextToken());   // 사각형 개수
        // (N,M)
        area = new boolean[M][N];
        for(int i=0;i < K;i++){
            String[] split = br.readLine().split(" ");
            insertBox(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]),Integer.parseInt(split[3]));
        }

        for(int i=0;i < N;i++){
            for(int j=0;j < M;j++){
                if(!area[j][i]){
                    count = 0;
                    DFS(i,j);
                    result.add(count);
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for(int value : result){
            System.out.print(value + " ");
        }


    }

    private static void DFS(int x, int y) {
        area[y][x] = true;
        count++;
        for(int i=0;i < 4;i++){
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx < 0 || my < 0 || mx == N || my == M){
                continue;
            }
            if(area[my][mx]) {
                continue;
            }
            if(!area[my][mx]) DFS(mx,my);
        }
    }

    private static void insertBox(int min_x, int min_y, int max_x, int max_y) {
        for(int i=min_x;i < max_x;i++){
            for(int j=min_y;j < max_y;j++){
                area[j][i] = true;
            }
        }
    }
}
