package programmers.bruteforce;

import java.util.ArrayList;
import java.util.List;

/**
 * 모음 사전
 */
public class BruteForce5 {

    List<String> list = new ArrayList<>();
    String[] words = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        combination(0, "");

        int count = list.indexOf(word) + 1;

        return count;
    }

    public void combination(int index, String str) {
        if (index >= 5) {
            return;
        }

        for (int i = 0; i < words.length; i++) {
            String nxtWord = str + words[i];
            list.add(nxtWord);
            combination(index + 1, nxtWord);
        }
    }
}
