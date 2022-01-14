package programmers;
import java.util.*;

//level1-14 폰켓몬
class Solution14 {
    public int solution(int[] nums) {
        int answer = 0;

        int number = nums.length/2;

        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        if(set.size()>=number){
            answer = number;
        }else{
            answer = set.size();
        }

        return answer;
    }
}
