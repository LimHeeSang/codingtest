package programmers.hash;
import java.util.*;

//hash2 전화번호 목록
class Hash2 {
    public boolean solution(String[] pb) {
        boolean answer = true;

        Arrays.sort(pb);

        for(int i=0; i<pb.length-1; i++){
            if(pb[i+1].startsWith(pb[i])){
                answer = false;
                break;
            }
        }

        return answer;
    }
}
