package BaekJoon.Silver;
import java.io.*;
import java.util.*;
public class 효율적인_해킹_S1 {
    static LinkedList<Integer>[] graph;
    static int[] result;
    static int maxComputer;
    static int max;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new LinkedList[N+1];
        result = new int[N+1];
        maxComputer = 0;
        for(int i=0;i <= N;i++){
            graph[i] = new LinkedList<>();
        }
        for(int i=0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            graph[to].add(from);        //단방향 그래프
        }
        max = 0;
        for(int i=1;i <= N;i++){
            if(graph[i].size() == 0){
                continue;
            }
            visited = new boolean[N+1];
            maxComputer = 0;
            DFS(i);
//            BFS(i);
//            result[i] = maxComputer;
//            max = Math.max(max,maxComputer);
        }
        for(int a : result){
            if(max < a){
                max = a;
            }
        }
        for(int i=1;i <= N;i++){
            System.out.println(result[i]);
            if(max == result[i]){
                sb.append(i).append(" ");
            }
        };

        System.out.println(sb);
    }
    private static void DFS(int value){
        visited[value] = true;
        for(int nextV : graph[value]){
            DFS(nextV);
            result[nextV]++;
        }
    }


    private static void BFS(int value) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(value);
        visited[value] = true;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            for(int nextV : graph[poll]){
                if(!visited[nextV]){
                    queue.add(nextV);
                    visited[nextV] = true;
                    maxComputer++;
                }
            }
        }
    }

}

