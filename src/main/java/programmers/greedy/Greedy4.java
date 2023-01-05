package programmers.greedy;

import java.util.Arrays;

/**
 * 단속카메라
 */
public class Greedy4 {

    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);

        int camera = -30001;
        for(int[] route : routes) {
            if(camera < route[0]) {
                camera = route[1];
                answer++;
            }

        }

        return answer;
    }
}
