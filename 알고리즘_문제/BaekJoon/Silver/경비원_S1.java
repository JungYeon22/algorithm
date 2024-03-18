package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 경비원_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int total = (width + height) << 1;

        int N = Integer.parseInt(in.readLine());

        //마지막 방은 동근이 위치
        int[] spots = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            int way = Integer.parseInt(st.nextToken());
            spots[i] = Integer.parseInt(st.nextToken());

            if (way == 2) spots[i] = width - spots[i];
            else if (way == 3) spots[i] = height - spots[i];

            switch (way) {
                case 3: spots[i] += width;
                case 2: spots[i] += height;
                case 4: spots[i] += width;
            }
        }

        //상점-동근위치 빼고, 그 길이와 토탈-길이 비교하기
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int len = Math.abs(spots[N] - spots[i]);
            sum += Math.min(len, total - len);
        }

        System.out.println(sum);
    }
}