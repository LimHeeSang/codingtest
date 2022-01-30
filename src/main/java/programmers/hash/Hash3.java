package programmers.hash;
import java.util.*;

//hash3 위장
class Hash3 {
    public int solution(String[][] clothes) {
        int count = 1;

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());

        for(int l : list){
            count *= (l+1);
        }

        return count-1;
    }
}
