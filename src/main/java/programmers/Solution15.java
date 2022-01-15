package programmers;
import java.util.*;

//level1-15 실패율
class Solution15 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] count = new int[N+2];
        Map<Integer, Double> map = new HashMap<>();

        int sum = stages.length;
        for(int s : stages){
            count[s]++;
        }

        for(int i=1; i<count.length-1; i++){
            if(count[i] == 0){
                map.put(i, 0D);
                continue;
            }
            map.put(i, (double)count[i]/(double)sum);
            sum -= count[i];
        }

        List<Integer> keySetList = new ArrayList<Integer>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        int i = 0;
        for (Integer key : keySetList) {
            i++;
            answer[i - 1] = key;
        }

        return answer;
    }
}
