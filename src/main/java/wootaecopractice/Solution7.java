package wootaecopractice;

public class Solution7 {

    public String solution(String cryptogram) {

        StringBuilder sb = new StringBuilder(cryptogram);

        boolean isDelete = true;
        while (isDelete) {
            isDelete = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);
                    isDelete = true;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        String result1 = solution7.solution("browoanoommnaon");
        String result2 = solution7.solution("zyelleyz");
        System.out.println(result1);
        System.out.println(result2);
    }
}
