package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 겹치는_선분의_길이_Lv0 {
    public static void main(String[] args) {
        int[][] lines = {{0,5},{3,9},{1,10}};
        Solution solution = new Solution();

       System.out.println(solution.solution(lines));
    }
}
class Solution {
    public int solution(int[][] lines) {
        boolean[] visited = new boolean[201];   // -100 ~ 100 =>  0 ~ 200
        int[] arr = new int[201];
        for(int i=0;i < lines.length;i++){
            int start = lines[i][0] + 100;
            int end = lines[i][1] + 100;

            // visited에 담기
            for(int k=start;k < end;k++){
                if(!visited[k]){
                    visited[k] = true;
                }
                else{
                    arr[k]++;
                }
            }
        }
        int count = 0;
        for(int data : arr){
            if(data > 0) count++;
        }
        return count;
    }
}
/*
방문여부 배열      boolean[] visit
겹친는 결과 배열   int[] arr
입력을 받는다.
입력을 받은 인덱스에서 visit[index] = true;
만약, 입력을 받은 인덱스가 true라면 arr[index]++;

시작점을 기준으로 차이만큼 돌면서 값을 더해줌
 */
