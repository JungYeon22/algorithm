package BaekJoon.Gold;
import java.io.*;
import java.util.*;
public class 적록색약_G4 {
    static BufferedReader br;
    static StringTokenizer st;
    static char[][] pixels;
    static int first,second,N;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pixels = new char[N][N];

        for(int i=0;i < N;i++){
            String input = br.readLine();
            for(int j=0;j < N;j++){
                pixels[i][j] = input.charAt(j);
            }
        }
        // 적록색약이 아닌 경우
        first = 0;
        second = 0;
        visited = new boolean[N][N];
        for(int i=0;i < N;i++){
            for(int j=0;j < N;j++){
                if(!visited[i][j]) {
                    BFS(i,j);
                    first++;
                }

            }
        }
        visited = new boolean[N][N];
        for(int i=0;i < N;i++){
            for(int j=0;j < N;j++){
                if(!visited[i][j]) {
                    BFS(i,j);
                    second++;
                }
            }
        }

        System.out.println(first + " " + second);

    }

    private static void BFS(int a,int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a,b});
        visited[a][b] = true;
        char target = pixels[a][b];
        if(target == 'G') pixels[a][b] = 'R';
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[1];
            int y = poll[0];
            for(int i=0;i < 4;i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                if(mx < 0 || my < 0 || mx >= N || my >= N){
                    continue;
                }
                if(!visited[my][mx] && target == pixels[my][mx]){
                    queue.add(new int[]{my,mx});
                    visited[my][mx] = true;
                    if(target == 'G'){
                        pixels[my][mx] = 'R';
                    }
                }

            }
        }

    }
}
