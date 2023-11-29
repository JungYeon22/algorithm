package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 촌수계산_S2 {
    static BufferedReader br;
    static StringTokenizer st;
    static LinkedList<Integer>[] graph;
    static int n;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());    //사람수
        st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(br.readLine());    //그래프 간선
        graph = new LinkedList[n+1];
        for(int i=0;i <= n;i++){
            graph[i] = new LinkedList<>();
        }
        for(int i=1;i <= v;i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }
        int count = BFS(target1,target2);
        System.out.println(count);

    }

    private static int BFS(int target1, int target2) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n+1];
        queue.add(target1);
        visited[target1] = 0;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            for(int i=0;i < graph[poll].size();i++){
                int point = graph[poll].get(i);
                if(visited[point] == 0){
                    visited[point] = visited[poll] + 1;
                    queue.add(point);
                }
                if(point == target2){
                    return visited[point];
                }
            }
        }
        return -1;
    }
}
