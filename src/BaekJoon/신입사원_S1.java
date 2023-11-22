package BaekJoon;

import java.io.*;
import java.util.*;
public class 신입사원_S1 {
    static BufferedReader br;
    static StringTokenizer st;
    static List<int[]> list;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i < T;i++){
            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            for(int j=0;j < N;j++){
                st = new StringTokenizer(br.readLine());
                int tmp[] = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
                list.add(tmp);
            }
            Collections.sort(list, ((o1, o2) -> o1[0] - o2[0]));
            int min = list.get(0)[1];
            int count=0;
            for(int j=0;j < N;j++){
                // 기준보다 순위가 낮다면(크다면)  ex) 기준 4 -> 5이면 더 낮은 순위
                int target = list.get(j)[1];
                if(target > min){
                    continue;
                }
                if(target <= min){
                    min = target;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
