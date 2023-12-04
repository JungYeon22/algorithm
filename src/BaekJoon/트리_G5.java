package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 트리_G5 {
    static BufferedReader br;
    static StringTokenizer st;
    static LinkedList<Integer>[] graph;
    static int rootNode,removeNode,count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 각 정점이 자식들을 가지고 있음
        // 자식이 없는 노드가 리프노드(자식이 없는 노드)
        graph = new LinkedList[N];      // 0 ~ N-1번까지 수
        for(int i=0;i < N;i++){
            graph[i] = new LinkedList<>();
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i < N;i++){
            int parentNode = Integer.parseInt(st.nextToken());
            if(parentNode == -1) {
                rootNode = i;
                continue;
            }
            graph[parentNode].add(i);       // 부모 노드를 알려줌 -> graph의 부모 노드에 현재 인덱스(자식노드)를 넣느다.
        }
        // 제거하는 노드를 제외 후 DFS로 리프노드 찾기
        removeNode = Integer.parseInt(br.readLine());
        count = 0;
        if(removeNode != rootNode){
            DFS(rootNode);
        }
        System.out.println(count);
    }

    private static void DFS(int node) {
        if(graph[node].size() == 0 || ( graph[node].size() == 1 && graph[node].get(0) == removeNode )){
            count++;
            return;
        }
        for(int i=0;i < graph[node].size();i++){
            int nextNode = graph[node].get(i);
            if(nextNode == removeNode){
                continue;
            }
            if(nextNode != removeNode){
                DFS(nextNode);
            }

        }
    }
}
