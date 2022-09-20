package wootaecopractice;

public class Solution5 {

    public int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += calculateNum(i);
        }
        return answer;
    }

    private int calculateNum(int num) {
        int count = 0;
        while (num != 0) {
            if (isSamYukGoo(num % 10)) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    private boolean isSamYukGoo(int num) {
        return num != 0 && num % 3 == 0;
    }


    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int result1 = solution5.solution(13);
        int result2 = solution5.solution(33);

        System.out.println(result1);
        System.out.println(result2);
    }
}
