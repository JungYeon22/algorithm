package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class SW_문제해결_기본_2일차_최대상금_D3 {

    static BufferedReader br;
    static StringTokenizer st;
    static int[] numberArray;
    static int N;
    static int max;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            max = 0;

            st = new StringTokenizer(br.readLine());
            numberArray = StringToIntArray(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if(N > numberArray.length) N = numberArray.length;

            DFS(0,0);
            sb.append("#").append(i).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void DFS(int s, int cnt) {
        if(cnt == N){
            int value = ArrayIntToInt();
            if(max < value){
                max = value;
            }
            return;
        }
        for(int i=0;i < numberArray.length;i++){
            for(int j=i+1;j < numberArray.length;j++){
                swap(i,j);
                DFS(i,cnt+1);
                swap(i,j);
            }
        }


    }

    private static int ArrayIntToInt() {
        int result=0;
        for(int a : numberArray){
            result = result*10 + a;
        }
        return result;
    }

    private static void swap(int i, int j) {
        int tmp = numberArray[i];
        numberArray[i] = numberArray[j];
        numberArray[j] = tmp;
    }


    private static int[] StringToIntArray(String nextToken) {
        String[] array = nextToken.split("");
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }


}
