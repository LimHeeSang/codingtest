package programmers;
import java.util.*;

//level1-16 약수의 개수와 덧셈
class Solution16 {
    public int solution(int left, int right) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for(int i=left; i<=right; i++){
            for(int j=1; j<=i; j++){
                if(i%j ==0){
                    if(!list.contains(j)) list.add(j);
                    if(!list.contains(i/j)) list.add(i/j);
                }
            }

            if(list.size()%2 == 0){
                answer += i;
            }else{
                answer -= i;
            }
            list.clear();
        }

        return answer;
    }
}
