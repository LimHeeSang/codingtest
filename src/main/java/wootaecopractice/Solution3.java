package wootaecopractice;

public class Solution3 {
    public String solution(String word) {
        final int value = 'a' + 'z';
        final int value2 = 'A' + 'Z';

        StringBuilder sb = new StringBuilder();
        char[] alphabets = word.toCharArray();
        for (char alphabet : alphabets) {
            if (alphabet >= 'a') {
                alphabet = (char) (value - alphabet);
            } else if (alphabet >= 'A') {
                alphabet = (char) (value2 - alphabet);
            }

            sb.append(String.valueOf(alphabet));
        }

        return sb.toString();
    }



    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        String answer = solution3.solution("I love you");
        System.out.println(answer);
    }
}
