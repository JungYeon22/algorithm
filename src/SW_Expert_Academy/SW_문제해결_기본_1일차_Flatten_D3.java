package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SW_문제해결_기본_1일차_Flatten_D3 {

    static BufferedReader br;
    static StringTokenizer st;
    static List<Integer> boxHeight;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=1;i <= 10;i++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            boxHeight = new ArrayList<>();
            while(st.hasMoreTokens()){
                boxHeight.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(boxHeight);

            for(int j=0;j < N;j++){
                solution();
            }

            int result = boxHeight.get(boxHeight.size()-1) - boxHeight.get(0);
            sb.append("#"+i+" ").append(result).append("\n");

        }
        System.out.println(sb);
    }

    private static void solution() {
        int height = boxHeight.get(boxHeight.size()-1) - 1;
        int low = boxHeight.get(0) + 1;
        boxHeight.remove(boxHeight.size()-1);
        boxHeight.remove(0);
        boxHeight.add(height);
        boxHeight.add(low);
        Collections.sort(boxHeight);
    }
}
