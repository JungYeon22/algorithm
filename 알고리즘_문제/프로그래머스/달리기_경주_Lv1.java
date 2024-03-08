package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 달리기_경주_Lv1 {
    class Solution {
        public String[] solution(String[] players, String[] callings) {
            Map<String, Integer> map = new HashMap<>();

            for(int i=0;i < players.length;i++){
                map.put(players[i], i);
            }
            for(int i=0;i < callings.length;i++){
                int index = map.get(callings[i]);
                String tmp = players[index];
                players[index] = players[index-1];
                players[index-1] = tmp;
                map.put(players[index-1], index-1);
                map.put(players[index]  , index);
            }
            return players;
        }
    }
}
