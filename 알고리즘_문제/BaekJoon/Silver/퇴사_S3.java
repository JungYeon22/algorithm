package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Schedule{
    int term;
    int cost;

    public Schedule(int term, int cost) {
        this.term = term;
        this.cost = cost;
    }
    public int getTerm() {
        return term;
    }
    public void setTerm(int term) {
        this.term = term;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
}

public class 퇴사_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Schedule[] schedules = new Schedule[N];
        int[] dp = new int[16];
        for(int i=0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            int term = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            schedules[i] = new Schedule(term, cost);
        }
        for(int i=0;i < N;i++){
            int term = schedules[i].getTerm();
            int cost = schedules[i].getCost();
            if(i + term <= N){
                dp[i + term] = Math.max(dp[i + term], dp[i] + cost);
             }
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }
        System.out.println(dp[N]);


    }
}
