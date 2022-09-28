package programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution10 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        if (words[0].length() == 1) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }

        Set<String> isUsed = new HashSet<>();
        isUsed.add(words[0]);
        char preEnd = words[0].charAt(words[0].length() - 1);

        int num = 2;
        int turn = 1;
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 1 || preEnd != word.charAt(0) || isUsed.contains(word)) {
                answer[0] = num;
                answer[1] = turn;
                break;
            }

            num++;
            if (num > n) {
                num = 1;
                turn++;
            }
            preEnd = word.charAt(word.length() - 1);
            isUsed.add(word);
        }

        if(answer[0] == 0){
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }
}
