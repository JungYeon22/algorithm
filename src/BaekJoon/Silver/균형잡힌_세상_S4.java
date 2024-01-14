package BaekJoon.Silver;

import java.util.Scanner;
import java.util.Stack;

public class 균형잡힌_세상_S4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack;
        while(true){
            stack = new Stack<>();
            String input = scanner.nextLine();
            if(input.charAt(0) == '.') break;
            for(int i=0;i < input.length();i++){
                char c = input.charAt(i);
                if(c == '(' || c == '['){
                    stack.add(c);
                }
                if(c == ')'){
                    if(stack.size() == 0 || stack.peek() != '(') {
                        stack.add(c);
                        break;
                    }
                    else if(stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }

                }
                if(c == ']'){
                    if(stack.size() == 0 || stack.peek() != '['){
                        stack.add(c);
                        break;
                    }
                    else if(stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }
                }
            }
            if(stack.size() == 0){
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.println(sb);

    }
}
