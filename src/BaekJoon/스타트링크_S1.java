package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크_S1 {
    static int upCount, downCount, target, total, start;
    static int min = Integer.MAX_VALUE;;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        total = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        upCount = Integer.parseInt(st.nextToken());
        downCount = Integer.parseInt(st.nextToken());

        BFS(start);

    }

    private static void BFS(int start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[total+1];   // 0 ~ 10
        visited[start] = true;
        queue.add(new int[]{start, 0});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == target) {
                if(min > now[1]){
                    min = now[1];
                }
                System.out.println(min);
                return;
            }
            int upNext = now[0] + upCount;
            int downNext = now[0] - downCount;
            if(upNext <= total && !visited[upNext]){
                visited[upNext] = true;
                queue.add(new int[]{upNext, now[1]+1});
            }
            if(downNext > 0 && !visited[downNext]){
                visited[downNext] = true;
                queue.add(new int[]{downNext, now[1]+1});
            }
        }
        System.out.println("use the stairs");


    }


}
