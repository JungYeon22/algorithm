package BaekJoon.Silver;

import java.util.Scanner;

public class 이친수_S3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Long[] arr = new Long[91];
        arr[0] = 0L;
        arr[1] = 1L;
        for(int i=2;i <= num;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[num]);
    }
}
/*
 1 :    1
 2 :    10
 3 :    100 / 101
 4 :    1000 / 1010 / 1001
 5 :    10000 / 10100 / 10010 / 10101 / 10001
 6 :    100000- / 101000- / 101010- / 101001-- / 100100- / 100101-- / 100010- / 100001--
 */