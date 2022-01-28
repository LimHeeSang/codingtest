package programmers.level1;
import java.util.*;

//level1-13 체육복
class Solution13 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        int[] people = new int[n+1];
        Arrays.fill(people, 1);

        for(int l : lost){
            people[l]--;
        }
        for(int r : reserve){
            people[r]++;
        }

        for(int i=1; i<people.length; i++){
            if(people[i] == 0){
                if(i-1>=1 && people[i-1] >=2){
                    people[i-1]--;
                    people[i]++;
                }else if(i+1<people.length && people[i+1] >=2){
                    people[i+1]--;
                    people[i]++;
                }else{
                    answer--;
                }
            }
        }


        return answer;
    }
}
