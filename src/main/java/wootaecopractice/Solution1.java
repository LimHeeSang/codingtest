package wootaecopractice;

import java.util.Arrays;

public class Solution1 {
    public int[] solution(int myMoney) {
        int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] result = new int[moneys.length];

        for (int i = 0; i < moneys.length; i++) {
            int money = moneys[i];

            if (myMoney >= money) {
                result[i] = myMoney / money;
                myMoney %=  money;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        int[] result1 = solution1.solution(50237);
        int[] result2 = solution1.solution(15000);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}
