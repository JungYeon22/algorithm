package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 집합의_표현_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 0 ~ N 개의 집합
        int M = Integer.parseInt(st.nextToken());   // 연산 개수
        List<List<Integer>> wholeList = new ArrayList<>();
        for(int i=0;i <= N;i++){        // 초기화
            List<Integer> list = new LinkedList<>();
            list.add(i);
            wholeList.add(list);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int calc = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            //합집합 연산

            int addList1 = -1;
            int addList2 = -1;
            for(int k=0;k < wholeList.size();k++){
                if(wholeList.get(k).contains(num1)) addList1 = k;
                if(wholeList.get(k).contains(num2)) addList2 = k;
//                for(int j=0;j < wholeList.get(k).size();j++){
//                    if(wholeList.get(k).get(j) == num1 || wholeList.get(k).get(j) == num2){
//                        if(addList1 < 0) addList1 = k;
//                        else if(addList2 < 0) addList2 = k;
//                    }
//                }
                if(addList1 >= 0 && addList2 >= 0) break;
            }
            if(addList1 == -1 || addList2 == -1) {
                if(calc == 1) sb.append("yes").append("\n");
            }
            else {
                if(calc == 1) sb.append("no").append("\n");
                else {
                    wholeList.get(addList1).addAll(wholeList.get(addList2));
                    wholeList.remove(addList2);
                }
            }

        }

        System.out.println(sb);

    }
}
