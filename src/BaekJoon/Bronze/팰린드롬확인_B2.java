package BaekJoon.Bronze;
import java.io.*;
import java.util.*;
public class 팰린드롬확인_B2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        Deque<Character> deque = new LinkedList<>();
        for(char a : target.toCharArray()){
            deque.add(a);
        }
        int check = 1;
        while(!deque.isEmpty()){
            if(deque.size() == 1){
                break;
            }
            if(deque.pollLast().equals(deque.pollFirst())){
                continue;
            }
            else {
                check = 0;
                break;
            }
        }
        System.out.println(check);
    }
}
