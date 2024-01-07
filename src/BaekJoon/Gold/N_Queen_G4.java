package BaekJoon.Gold;
import java.util.*;
import java.io.*;

public class N_Queen_G4 {
    static int count,N;
    static List<int[]> queen;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = 0;
        for(int i=0;i < N;i++){
            queen = new ArrayList<>();
            queen.add(new int[]{0,i});
            backTracking(1);
        }
        System.out.println(count);
    }

    private static void backTracking(int line) {
        if(line == N){
            count++;
        }
        for(int i=0;i < N;i++){
            for(int j=0;j < queen.size();j++){
                int[] loc = queen.get(j);
                if(loc[0] != line && loc[1] != i && (loc[0] - line) != (loc[1] - i)){
                    queen.add(new int[]{line,i});
                    backTracking(line+1);
                    queen.remove(queen.size()-1);
                }
            }
        }
        return;
    }
}
