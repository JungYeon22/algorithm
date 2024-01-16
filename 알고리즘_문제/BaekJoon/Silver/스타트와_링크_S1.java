package BaekJoon.Silver;
import java.io.*;
import java.util.*;
public class 스타트와_링크_S1 {
    static int min = Integer.MAX_VALUE;
    static StringTokenizer st;
    static int[][] graph;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N];
        for(int i=0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j < N;j++){
                int value = Integer.parseInt(st.nextToken());
                graph[i][j] = value;
            }
        }

        combi(0,0);

        System.out.println(min);

    }

    private static void combi(int num, int count) {
        if(count == N/2){
            calculate();
            return;
        }
        for(int i=num;i < N;i++){
            if(!visited[i]){
                visited[i] = true;
                combi(i+1,count+1);
                visited[i] = false;
            }
        }

    }

    private static void calculate() {
        int startTeam = 0;
        int linkTeam = 0;
        for(int i=0;i < N;i++){
            for(int j=0;j < N;j++){
                if(visited[i] && visited[j]){
                    startTeam += graph[i][j];
                }
                if(!visited[i] && !visited[j]){
                    linkTeam += graph[i][j];
                }
            }
        }
        int diff = Math.abs(startTeam-linkTeam);
        min = Math.min(diff,min);
    }


}
