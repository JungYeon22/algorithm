package SWEA;

import java.io.*;
import java.util.*;

public class N_Queen_D3 {

    static BufferedReader br;
    static StringBuilder sb;
    static int result;
    static int[] board;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            board = new int[N];
            result = 0;
            N_Queen(N, 0);

            sb.append("#").append(i).append(" ").append(result+"\n");
        }
        System.out.println(sb);

    }

    private static void N_Queen(int n, int start) {
        if(n == start){
            result++;
            return;
        }
        for(int i=0;i < n;i++){             // x축 / 열 번호
            boolean isPossible = true;
            for(int j=0;j < start;j++){     // y축 / 행의 번호
                if(board[j] == i || i == board[j] + (start - j) || i == board[j] - (start - j)){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible){
                board[start] = i;
                N_Queen(n, start+1);
            }
        }


    }




}
