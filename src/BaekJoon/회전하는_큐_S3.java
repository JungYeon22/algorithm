package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회전하는_큐_S3 {
    static BufferedReader br;
    static StringTokenizer st;
    static LinkedList<Integer> dq;
    static int count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());    // 큐의 크기
        int M = Integer.parseInt(st.nextToken());    // 제거할 원소 개수
        st = new StringTokenizer(br.readLine());
        dq = new LinkedList<>();
        count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            list.add(value);
        }
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            int target = list.get(i);
            solution(target);
            dq.poll();
        }
        System.out.println(count);

    }

    private static void solution(int target) {
        int mid_index = 0;

        if(dq.size() % 2 == 0){
            mid_index = dq.size() / 2;
        }
        if(dq.size() % 2 != 0){
            mid_index = dq.size() / 2 + 1;
        }

        if(dq.indexOf(target) >= mid_index){
            int size = dq.size() - dq.indexOf(target);
            for(int i=0;i < size;i++){
                dq.addFirst(dq.pollLast());
                count++;
            }
        }
        if(dq.indexOf(target) < mid_index){
            int size = dq.indexOf(target);
            for(int i=0;i < size;i++){
                dq.addLast(dq.poll());
                count++;
            }
        }
    }

}
