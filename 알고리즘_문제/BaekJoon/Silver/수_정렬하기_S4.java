package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수_정렬하기_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i=0;i < N;i++){
            int value = Integer.parseInt(br.readLine());
            list.add(value);
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for (int a : list){
           sb.append(a).append("\n");
        }
        System.out.println(sb);

    }
}
