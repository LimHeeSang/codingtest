package programmers.hash;
import java.util.*;

//hash1 완주하지 못한 선수
class Hash1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0)+1);
        }

        for(String c : completion){
            map.put(c, map.get(c)-1);
        }

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for(Map.Entry<String, Integer> entry : entrySet){
            if(entry.getValue() != 0) answer = entry.getKey();
        }


        return answer;
    }
}
