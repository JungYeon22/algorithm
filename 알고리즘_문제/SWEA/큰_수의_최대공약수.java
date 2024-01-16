package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큰_수의_최대공약수 {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=1;i <= T;i++){
            st = new StringTokenizer(br.readLine());
            long num1 = Long.parseLong(st.nextToken());
            long num2 = Long.parseLong(st.nextToken());
            long result = 0;
            long range = num2 - num1;
            if(range == 0){
                result = num1;
            }
            if(range >= 1){
                result = 1;
            }
            
            sb.append("#"+i+" ").append(result).append("\n");

        }
        System.out.println(sb);
    }
}
