package BaekJoon;

import java.io.*;
import java.util.*;
public class 이분그래프_G4 {
    static BufferedReader br;
    static StringTokenizer st;
    static LinkedList<Integer>[] graph;
    static char set[];

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for(int i=0;i < K;i++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new LinkedList[V+1];
            for(int j=0;j <= V;j++){
                graph[j] = new LinkedList<>();
            }
            for(int j=0;j < E;j++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                graph[v1].add(v2);
                graph[v2].add(v1);
            }
            set = new char[V+1];
            boolean check = true;
            for(int j=1;j <= V;j++){
                if(set[j] =='\0'){
                    check = BFS(j);
                }
                if(!check){
                    break;
                }
            }
            if(!check){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }

    }

    private static boolean BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        set[v] = 'A';
        while(!queue.isEmpty()){
            int nowV = queue.poll();
            char nowSet = set[nowV];
            char nextSet = 'A';
            if(nowSet == 'A'){
                nextSet = 'B';
            }
            for(int nextV : graph[nowV]){
                if(set[nextV] == nextSet){
                    continue;
                }
                if(set[nextV] == nowSet){
                    return false;
                }
                if(set[nextV] == '\0'){
                    queue.add(nextV);
                    set[nextV] = nextSet;
                }
            }
        }
        return true;
    }

}