package programmers;
import java.util.*;

//level1-13 체육복
class Solution13 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] counts = new int[n+1];
        Arrays.fill(counts, 1);

        for(int num: reserve){
            counts[num]++;
        }

        for(int num : lost){
            counts[num]--;
        }

        for(int i=1; i<counts.length; i++){
            if(counts[i] == 0){
                if(i==1){
                    if(counts[i+1] >= 2){
                        counts[i]++;
                        counts[i+1]--;
                    }
                }else if(i==counts.length-1){
                    if(counts[i-1] >= 2){
                        counts[i]++;
                        counts[i-1]--;
                    }
                }else{
                    if(counts[i-1] >= 2){
                        counts[i]++;
                        counts[i-1]--;
                        continue;
                    }
                    if(counts[i+1] >= 2){
                        counts[i]++;
                        counts[i+1]--;
                    }
                }

            }
        }

        for(int i=1; i<counts.length; i++){
            if(counts[i] != 0) answer++;
        }

        return answer;
    }
}
