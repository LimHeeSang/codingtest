package programmers.greedy;

import java.util.Arrays;

/**
 * 구명보트
 */
public class Greedy2 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;

        while(start <= end) {
            int sum = people[start] + people[end];

            if(sum > limit){
                end--;
            }else if(sum <= limit) {
                start++;
                end--;
            }
            answer++;
        }

        return answer;
    }
}
