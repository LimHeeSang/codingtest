package programmers.level1;
import java.util.*;

//level1-45 제일 작은 수 제거하기
class Solution45 {
    public int[] solution(int[] arr) {
        int[] answer;

        if(arr.length == 1){
            answer = new int[]{-1};
            return answer;
        }

        answer = new int[arr.length-1];

        int minIndex = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < arr[minIndex]) minIndex = i;
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(i != minIndex) list.add(arr[i]);
        }

        int idx = 0;
        for(int l : list){
            answer[idx++] = l;
        }

        return answer;
    }
}