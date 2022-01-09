package programmers;

//level1-12 모의고사
import java.util.*;
class Solution12 {
    public int[] solution(int[] answers) {
        
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] count = new int[3];
        count[0] = check(person1, answers);
        count[1] = check(person2, answers);
        count[2] = check(person3, answers);

        int max=0;
        for(int num : count) max = Math.max(max, num);

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<count.length; i++){
            if(count[i] == max){
                list.add(i+1);
            }
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;

    }

    public int check(int[] person, int[] answers){
        int count=0;

        int index = 0;
        for(int answer : answers){
            if(index> person.length-1){
                index=0;
            }

            if(answer == person[index++]){
                count++;
            }
        }

        return count;
    }

}
