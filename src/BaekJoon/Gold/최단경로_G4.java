package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로_G4 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] dist;
    static List<int[]>[] graph;
    static int[] visited;
    static int V,E,K;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());   // 정점의 개수
        E = Integer.parseInt(st.nextToken());   //간선의 개수
        K = Integer.parseInt(br.readLine());    //시작 정점
        dist = new int[V+1][V+1];
        graph = new List[V+1];
        visited = new int[V+1];
        for(int i=0;i <= V;i++){
            graph[i] = new ArrayList<>();
            visited[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i < E;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            dist[start][end] = amount;
            graph[start].add(new int[]{end, amount});
        }
        BFS(K);

        for(int i=1;i <= V;i++){
            if(K == i) {
                System.out.println(0);
                continue;
            }
            int result = visited[i];
            if(result == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(visited[i]);
            }
        }
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] check = new boolean[V+1];
        queue.add(start);
        visited[start] = 0;
        while(!queue.isEmpty()){
            int now = queue.poll();

            if(check[now]) continue;
            check[now] = true;

            for(int i=0;i < graph[now].size();i++){
                int[] move = graph[now].get(i);         //move[0] : 도착 정점 / move[1] : 가중치
                if(visited[move[0]] > visited[now] + move[1]) {
                    visited[move[0]] = visited[now] + move[1];
                    queue.add(move[0]);
                }

            }
        }


    }
}
