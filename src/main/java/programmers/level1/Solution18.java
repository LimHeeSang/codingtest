package programmers.level1;
import java.util.*;

//level1-18 예산
class Solution18 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        for(int i=0; i<d.length; i++){
            if(d[i] <= budget){
                budget -= d[i];
                answer++;
            }else{
                break;
            }
        }

        return answer;
    }
}
