package SW_Expert_Academy;
/*
입력 :
- 테스트 케이스 T
- 예측 일수 N
- 각 날의 매매가
출력
- #번호 (최대이익)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 백만_장자_프로젝트_D2 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static List<Integer> inputList;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int j = 1; j <= T; j++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            inputList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                inputList.add(num);
                System.out.println(num);
            }
            long result = predict();
            sb.append("#").append(j).append(" ").append(result).append("\n");
        }
        System.out.println(sb);


    }

    private static long predict() {
        long sum = 0L;
        int size = inputList.size();
        int max = Collections.max(inputList);
        for (int i = 0; i < size; i++) {
            System.out.println("i : " + i);
            if (max == inputList.get(0)) {
                System.out.println("max , inputList : "+max);
                inputList.remove(0);
                if(inputList.isEmpty()) break;
                max = Collections.max(inputList);
            } else {
                sum = sum + (max - inputList.get(0));
                inputList.remove(0);
            }

        }
        return sum;

    }


}