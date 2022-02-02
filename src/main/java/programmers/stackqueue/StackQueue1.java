package programmers.stackqueue;
import java.util.*;

//stackqueue1 기능개발
class StackQueue1 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> temp = new ArrayList<>();
        boolean[] check = new boolean[speeds.length];

        int total = 0;
        int count;

        while(total != speeds.length){

            count = 0;

            for(int i=0; i<speeds.length; i++){
                progresses[i] = progresses[i] + speeds[i];
            }

            for(int i=0; i<progresses.length; i++){

                if(progresses[i] >= 100 && !check[i]){
                    check[i] = true;
                    count++;
                    total++;
                }
                if(check[i]) continue;
                else break;
            }

            if(count != 0) temp.add(count);

        }

        answer = new int[temp.size()];
        for(int i=0; i<temp.size(); i++){
            answer[i] = temp.get(i);
        }


        return answer;
    }
}
