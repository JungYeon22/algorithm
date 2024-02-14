package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의_표현_G5 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 0 ~ N 개의 집합
        int M = Integer.parseInt(st.nextToken());   // 연산 개수

        arr = new int[N+1];   // 0~N개의 집합
        for(int i=0;i <= N;i++){
            arr[i] = i;
        }
        for(int i=0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int calc = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if(calc == 1){
                isSameArea(num1,num2);
            }
            else if(calc == 0){
                union(num1,num2);
            }
        }

    }

    private static void isSameArea(int num1, int num2) {
        int x = find(num1);
        int y = find(num2);
        if(x==y) System.out.println("yes");
        else System.out.println("no");
    }

    private static void union(int num1, int num2) {
        int x = find(num1);
        int y = find(num2);
        if(x != y){
            if(x < y) arr[y] = x;
            else arr[x] = y;
        }
    }

    private static int find(int num) {
        if(num == arr[num]){
            return num;
        }
        else {
            return arr[num] = find(arr[num]);
        }
    }


}
