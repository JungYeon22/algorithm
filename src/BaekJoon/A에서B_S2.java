package BaekJoon;
import java.io.*;
import java.util.*;
public class A에서B_S2 {
    static BufferedReader br;
    static StringTokenizer st;
    static class Number{
        private long number;
        private int count;

        public Number(long number, int count) {
            this.number = number;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // A -> B
        // 1. 2를 곱한다.
        // 2. 1을 오른쪽에 추가한다.

        BFS(A,B);

    }

    private static void BFS(int a, int target) {
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(a,1));
        while(!queue.isEmpty()){
            Number now = queue.poll();
            if(now.number == target){
                System.out.println(now.count);
                return;
            }
            if(now.number > target){
                continue;
            }
            String value = String.valueOf(now.number) + "1";
            queue.add(new Number(Long.parseLong(value),now.count+1));
            queue.add(new Number(now.number * 2, now.count+1));
        }
        System.out.println(-1);
    }
}
