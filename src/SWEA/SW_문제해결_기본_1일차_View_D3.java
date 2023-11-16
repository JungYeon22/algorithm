package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_문제해결_기본_1일차_View_D3 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static List<Integer> buildingList;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        for(int i=1;i <= 10;i++){
            //입력
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            buildingList = new ArrayList<>();
            for(int j=0;j < N;j++){
                buildingList.add(Integer.valueOf(st.nextToken()));
            }
            // 기능
            int count =0;
            for(int j=2;j < N-2;j++){
                if(j == 2){
                    int rightMin = rightValidate(j);        // 오른쪽 빌딩의 높이 차이 최소
                    count += rightMin;
                    continue;
                }
                if(j == N-2){
                    int leftMin = leftValidate(j);
                    count += leftMin;
                    continue;
                }
                else {
                    int rightMin = rightValidate(j);
                    int leftMin = leftValidate(j);
                    if(rightMin == 0 || leftMin == 0){
                        continue;
                    }
                    else {
                        count += Math.min(rightMin,leftMin);
                    }

                }
            }
            sb.append("#").append(i).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static int leftValidate(int num) {
        int height = buildingList.get(num);
        int left1 = buildingList.get(num-1);
        int left2 = buildingList.get((num-2));
        if(height <= left1 || height <= left2){
            return 0;
        }
        else {
            return height - Math.max(left1,left2);
        }
    }

    private static int rightValidate(int num) {
        int height = buildingList.get(num);
        int right1 = buildingList.get(num+1);
        int right2 = buildingList.get((num+2));
        if(height <= right1 || height <= right2){
            return 0;
        }
        else {
            return height - Math.max(right1,right2);
        }
    }
}
