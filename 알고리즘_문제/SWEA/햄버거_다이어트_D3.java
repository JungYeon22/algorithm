package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 햄버거_다이어트_D3 {
    static BufferedReader br;
    static StringTokenizer st;
    static LinkedList<Integer>[] list;
    static int N, L;
    static int maxScore;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // 재료 개수
            L = Integer.parseInt(st.nextToken());   // 제한 칼로리
            list = new LinkedList[N];
            maxScore = 0;
            for (int j = 0; j < N; j++) {
                list[j] = new LinkedList<>();           // 초기화
            }
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());       // 재료 맛평가 점수
                int calorie = Integer.parseInt(st.nextToken());     // 재료 칼로리
                list[j].add(score);
                list[j].add(calorie);
            }

            DFS(0, 0, 0);

            sb.append("#").append(i).append(" ").append(maxScore);
            if (i != T) {
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }

    private static void DFS(int curr, int sumScore, int sumCalorie) {
        if (sumCalorie > L) {
            return;
        }
        if (curr >= N) {
            if (maxScore < sumScore) {
                maxScore = sumScore;
            }
            return;
        }

        int score = list[curr].get(0);
        int calorie = list[curr].get(1);
        DFS(curr + 1, sumScore + score, sumCalorie + calorie);
        DFS(curr + 1, sumScore, sumCalorie);
    }

}
