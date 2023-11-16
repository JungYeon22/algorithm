package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 간단한_369게임_D2 {

    static BufferedReader br;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            int count = validation(i);
            if (count == 0) sb.append(i);
            while (count-- > 0) {
                sb.append("-");
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private static int validation(int num) {
        int count = 0;
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '3' || arr[i] == '6' || arr[i] == '9') {
                count++;
            }
        }
        return count;
    }

}
