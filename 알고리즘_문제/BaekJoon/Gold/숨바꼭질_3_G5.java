package BaekJoon.Gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질_3_G5 {
    static int[] map = new int[100001];
    static int start, target;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start = scanner.nextInt();
        target = scanner.nextInt();

        int bfs = BFS(start);
        System.out.println(bfs);
    }


    private static int BFS(int start) {
        boolean visited[] = new boolean[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        map[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll(); // 현재 위치

            // * 2 => 순간이동
            if(now*2 > 0 && now*2 <= 100000){
                if(!visited[now*2]){
                    queue.add(now*2);
                    map[now*2] = map[now];
                    visited[now*2] = true;
                }
                // 이미 있는 경우
                else{
                    map[now*2] = Math.min(map[now*2], map[now]);
                }
            }

            // 앞으로 한칸 +1
            if(now + 1 <= 100000){
                if(!visited[now + 1]){
                    queue.add(now+1);
                    map[now+1] = map[now] + 1;      // 초 +1
                    visited[now+1] = true;
                }
                // 이미 있는 경우
                else{
                    map[now+1] = Math.min(map[now+1], map[now] + 1);
                }
            }
            // 뒤로 한칸 -1
            if(now - 1 >= 0){
                if(!visited[now-1]){
                    queue.add(now-1);
                    map[now-1] = map[now] + 1;      // 초 +1
                    visited[now-1] = true;
                }
                // 이미 있는 경우
                else{
                    map[now-1] = Math.min(map[now-1], map[now] + 1);
                }
            }
        }
        return map[target];
    }
}
