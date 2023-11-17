package softeerbootcamp;

import java.io.*;
import java.util.*;

class test {
    static StringTokenizer st;
    static int[][] area;
    static List<Integer> result;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());
        area = new int[lines][lines];
        result = new ArrayList<>();
        visited = new boolean[lines][lines]; // [y][x]
        for(int i=0; i<lines; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j < lines;j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i < lines;i++){         // x
            for(int j=0;j < lines;j++){     // y
                if(visited[j][i] || area[j][i] == 0) continue;
                if(!visited[j][i] || area[j][i] == 1){
                    int count = BFS(lines, i,j);
                    result.add(count);
                }

            }
        }
        System.out.println(result.size());
        if(result.size() != 0){
            StringBuilder sb = new StringBuilder();
            Collections.sort(result);
            for(int i=0;i < result.size();i++){
                sb.append(result.get(i));
                if(i == result.size()){
                    break;
                }
                sb.append(" ");
            }
            System.out.println(sb);
        }

    }

    private static int BFS(int lines, int x_start, int y_start) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x_start,y_start});
        int count = 0;
        while (!queue.isEmpty()){
            int[] target = queue.poll();
            count++;
            int x = target[0];
            int y = target[1];
            for(int i=0;i < 4;i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                if(mx < 0 || my < 0 || mx == lines || my == lines){
                    continue;
                }
                if(visited[my][mx] || area[my][mx] == 0){
                    continue;
                }
                if(!visited[my][mx] && area[my][mx] == 1){
                    queue.add(new int[]{mx,my});
                    visited[my][mx] = true;
                }
            }
        }
        return count-1;

    }
}