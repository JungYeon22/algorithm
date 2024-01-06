package BaekJoon.Gold;

import java.io.*;
import java.util.*;

public class 문자열_폭발_G4 {
    static BufferedReader br;
    static Stack<Character> s;
    static String input,bomb;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        bomb = br.readLine();

        s = new Stack<>();

        for(int i=0;i < input.length();i++){
            s.add(input.charAt(i));
            if(s.size() >= bomb.length()){
                boolean check = true;
                for(int j=0;j < bomb.length();j++){
                    if(s.get(s.size()-bomb.length()+j) != bomb.charAt(j)){
                        check = false;
                        break;
                    }
                }
                if(check){
                    for(int j=0;j < bomb.length();j++){
                        s.pop();
                    }
                }

            }
        }
        if(s.isEmpty()){
            System.out.println("FRULA");
        }
        else {
            StringBuilder sb = new StringBuilder();
            for(char a: s){
                sb.append(a);
            }
            System.out.println(sb);
        }

    }

}
