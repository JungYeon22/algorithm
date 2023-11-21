package BaekJoon;

import java.io.*;
import java.util.*;

public class 수_묶기_G4 {
    static BufferedReader br;
    static List<Integer> nList = new ArrayList<>();
    static List<Integer> pList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if(value > 0){
                pList.add(value);
            }
            if(value <= 0){
                nList.add(value);
            }
        }


        Collections.sort(pList,Collections.reverseOrder());
        Collections.sort(nList);
        List<Integer> resultList = new ArrayList<>();
        int index = 0;
        while (index < pList.size()) {
            if(index + 1 < pList.size() && pList.get(index) != 1 && pList.get(index+1) != 1){
                int value = pList.get(index) * pList.get(index + 1);
                resultList.add(value);
                index += 2;
            }
            else{
                resultList.add(pList.get(index++));
            }

        }
        index = 0;
        while (index < nList.size()) {
            if(index + 1 < nList.size()){
                int value = nList.get(index) * nList.get(index + 1);
                resultList.add(value);
                index += 2;
            }
            else{
                resultList.add(nList.get(index++));
            }
        }

        int sum =0;
        for(int i : resultList){
            sum += i;
        }

        System.out.print(sum);

    }
}
