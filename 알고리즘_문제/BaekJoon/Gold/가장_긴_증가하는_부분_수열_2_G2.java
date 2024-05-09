package BaekJoon.Gold;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열_2_G2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0;i < N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0;i < N;i++){
            // 리스트에 추가
            if(list.size() == 0 || list.get(list.size()-1) < A[i]){
                list.add(A[i]);
            }
            else {
                int left = 0;
                int right = list.size()-1;
                while(left < right){
                    int mid = (left + right) / 2;
                    if( list.get(mid) < A[i]){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                list.set(right, A[i]);
            }
        }
        System.out.println(list.size());
    }
}
