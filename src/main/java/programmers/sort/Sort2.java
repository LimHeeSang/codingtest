package programmers.sort;
import java.util.*;

//sort2 H-Index
class Sort2 {
    public int solution(int[] citations) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for(int c : citations){
            list.add(c);
        }

        Collections.sort(list, Collections.reverseOrder());

        int count = 0;
        int temp = 0;
        for(int i=Collections.max(list); i>= 0; i--){
            count = 0;
            temp = 0;
            for(int j=0; j<list.size(); j++){
                if(list.get(j) >= i){
                    count++;
                }else{
                    break;
                }
                temp = list.size()-j;
            }

            if(count >= i &&  temp <= i){
                answer = i;
                break;
            }
        }

        return answer;
    }
}
