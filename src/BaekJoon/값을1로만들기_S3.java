package BaekJoon;

import java.util.Scanner;
// 기능 : 3으로 나누거나 2로 나누거나 -1하기
public class 값을1로만들기_S3 {
    static Integer[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        arr = new Integer[num+1];

        arr[0] = arr[1] = 0;
        System.out.println(DP(num));
    }

    private static int DP(int num) {
        if(arr[num] == null){
            if(num % 6 == 0) {
                arr[num] = Math.min(DP(num/3),Math.min(DP(num/2),DP(num-1)))+1;
            }
            else if(num % 3 == 0){
                arr[num] = Math.min(DP(num/3),DP(num-1))+1;
            }
            else if(num % 2 == 0){
                arr[num] = Math.min(DP(num/2),DP(num-1))+1;
            }
            else {
                arr[num] = DP(num-1)+1;
            }
        }

        return arr[num];

    }
}
