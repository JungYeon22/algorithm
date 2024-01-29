package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split("");
        String[] input2 = br.readLine().split("");

        int[][] lcs = new int[input1.length+1][input2.length+1];
        int max = 0;
        for(int i=1;i <= input1.length;i++){
            for(int j=1;j <= input2.length;j++){
                if(input1[i-1].equals(input2[j-1])){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                    max = Math.max(lcs[i][j], max);
                }
                else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        for(int i=0;i < lcs.length;i++){
            for(int j=0;j < lcs.length;j++){
                System.out.print(lcs[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(max);


    }
}
