package BaekJoon;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쉬운_계단_수_S1 {
    static BufferedReader br;
    static StringTokenizer st;
    static int count;
    static int N;
    static int[] stairsNum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairsNum = new int[N];
        count = 0;
        // 1 ~ 9
        for (int i = 1; i < 10; i++) {
            solution(i, 0);
        }
        System.out.println(count % 1000000000);

    }

    private static void solution(int num, int index) {
        if (num < 0 || num > 9) return;
        if (index == N-1) {
            count++;
            return;
        }
        solution(num + 1, index + 1);
        solution(num - 1, index + 1);


    }
}
