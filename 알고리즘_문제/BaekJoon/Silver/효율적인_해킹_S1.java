package BaekJoon.Silver;
import java.io.*;
import java.util.*;
public class 효율적인_해킹_S1 {
    static int N,M;
    static LinkedList[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new LinkedList[N+1];    // N개의 컴퓨터 생성
        for(int i=0;i < list.length;i++){
            list[i] = new LinkedList<Integer>();
        }

        boolean[] init = new boolean[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            // com1 이 com2를 신뢰한다. (단방향)
            list[com2].add(com1);
            init[com1]= true;
        }
        int maxCount = 0;
        int arr[] = new int[N+1];
        for(int i=1;i < list.length;i++){
            if(init[i]) continue;
            int count = BFS(i);
            arr[i] = count;
            maxCount = Math.max(count, maxCount);
        }
        List<Integer> list1 = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i < arr.length;i++){
            if(maxCount == arr[i]){
                pq.add(i);
            }
        }
        int max = pq.poll();
        sb.append(max).append(" ");
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);
    }

    private static int BFS(int num) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = true;
        int count = 1;
        while(!q.isEmpty()){
            Integer poll = q.poll();
            for(int i=0;i< list[poll].size();i++){
                int nextNum = (int)list[poll].get(i);
                if(!visited[nextNum] && nextNum!=0){
                    q.add(nextNum);
                    visited[nextNum] = true;
                    count++;
                }
            }
        }
        return count;
    }

}

