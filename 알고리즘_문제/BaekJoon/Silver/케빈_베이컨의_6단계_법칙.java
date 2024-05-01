package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈_베이컨의_6단계_법칙 {
    static int N,M;

    static LinkedList[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 사람수
        M = Integer.parseInt(st.nextToken());   // 관계수
        graph = new LinkedList[N+1];

        // 초기화
        for(int i=0;i <= N;i++){
            graph[i] = new LinkedList<Integer>();
        }

        // 그래프 담기
        for(int i=0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }


        //각 사함들(linkedList 배열 인덱스)이 BFS를 거처 최대 깊이를 구하자
        int minResult = Integer.MAX_VALUE;
        int resultIndex = 0;
        for(int i=1;i <= N;i++){
            int maxCount = BFS(i, graph);
            if(maxCount < minResult){
                minResult =  maxCount;
                resultIndex = i;
            }
        }
        System.out.println(resultIndex);

    }

    private static int BFS(int index, LinkedList[] graph) {
        Integer visited[] = new Integer[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = 0;
        int count =0;
        while(!queue.isEmpty()){
            Integer now = queue.poll();
            for(int i=0;i < graph[now].size();i++){
                int next = (int) graph[now].get(i);
                if(visited[next] == null){
                    queue.add((next));
                    visited[next] = visited[now] + 1;
                }
            }
        }

        for(Integer a : visited){
            if(a != null){
                count += a;
            }
        }
        return count;
    }


}
/*
LinkedList[]    :         1      2     3        4      5
                         3,4     3   1,4,2    1,5,3    4

             visited[]  1 ~ 5
* */
