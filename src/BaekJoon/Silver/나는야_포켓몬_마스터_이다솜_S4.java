package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,String> numMap = new HashMap();
        Map<String,Integer> nameMap = new HashMap();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for(int i=1;i <= M;i++){
            String name = br.readLine();
            numMap.put(i, name);
            nameMap.put(name, i);
        }
        for(int i=0;i < N;i++){
            String input = br.readLine();
            if (input.charAt(0) >= 'A'){
                // 캐릭터 이름 입력
                System.out.println(nameMap.get(input));
            }
            else {
                // 번호 입력
                System.out.println(numMap.get(Integer.parseInt(input)));
            }
        }

    }
}
