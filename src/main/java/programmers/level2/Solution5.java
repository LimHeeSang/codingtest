package programmers.level2;

import java.util.Deque;
import java.util.LinkedList;

public class Solution5 {

    boolean solution(String s) {
        Deque<Character> dq = new LinkedList<>();
        char[] arr = s.toCharArray();
        dq.offerLast(arr[0]);

        for(int i=0; i<arr.length; i++){
            char ch = dq.peekLast();
            if(arr[i] == '('){
                dq.offerLast('(');
            }else{  //')'
                if(ch == '('){
                    dq.pollLast();
                }else{
                    dq.offerLast(arr[i]);
                }
            }
        }

        if(dq.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
