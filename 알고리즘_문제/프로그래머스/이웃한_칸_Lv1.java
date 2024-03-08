package 프로그래머스;

public class 이웃한_칸_Lv1 {
    class Solution {
        public int solution(String[][] board, int h, int w) {
            int[] dh = {1, -1, 0 ,0};
            int[] dw = {0, 0, 1, -1};
            int count = 0;
            String color = board[h][w];

            for(int i=0;i < 4;i++){
                int mh = h + dh[i];
                int mw = w + dw[i];
                if(mh < 0 || mw < 0 || mh >= board.length || mw >= board[0].length){
                    continue;
                }
                if(board[mh][mw].equals(color)){
                    count++;
                }
            }
            return count;
        }
    }
}
