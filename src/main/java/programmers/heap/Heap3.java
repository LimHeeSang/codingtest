package programmers.heap;
import java.util.*;

//heap3 이중우선순위큐
class Heap3 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        List<Integer> list = new LinkedList<>();

        for(String s : operations){
            int num = 0;

            if(s.charAt(0) == 'I'){
                num = Integer.parseInt(s.substring(2, s.length()));
                list.add(num);
            }else{  //D일경우
                Collections.sort(list);

                if(s.length() == 3 && !list.isEmpty()){ //최댓값 삭제
                    list.remove(list.size()-1);
                }else if(s.length() == 4 && !list.isEmpty()){   //최솟값 삭제
                    list.remove(0);
                }

            }
        }

        if(list.isEmpty()) return new int[]{0, 0};
        else{
            Collections.sort(list);
            answer[0] = list.get(list.size()-1);
            answer[1] = list.get(0);
        }

        return answer;
    }
}
