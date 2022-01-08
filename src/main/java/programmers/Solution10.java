package programmers;

import java.util.*;

//level1-10 완주하지 못한 선수
class Solution10 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for(String name : participant){
            map.put(name, map.getOrDefault(name, 0)+1);
        }

        for(String name : completion){
            map.put(name, map.get(name)-1);
        }

        for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
                break;
            }
        }

        return answer;
    }
}
