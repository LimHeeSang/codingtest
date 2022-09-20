package wootaecopractice;

import java.util.Arrays;

public class Solution4 {
    public int solution(int[] pobi, int[] crong) {
        int answer;

        if (!validatePobiCrongBook(pobi, crong)) {
            answer = -1;
            return answer;
        }

        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);

        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }

    public int calculateScore(int[] book) {
        int leftPage = book[0];
        int rightPage = book[1];
        int maxScore = 0;

        int[] result = new int[4];
        result[0] = calculateSum(leftPage);
        result[1] = calculateMul(leftPage);
        result[2] = calculateSum(rightPage);
        result[3] = calculateMul(rightPage);

        for (int r : result) {
            maxScore = Math.max(maxScore, r);
        }
        return maxScore;
    }

    public int calculateSum(int number) {
        int[] numbers = changeNumberToArray(number);
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public int calculateMul(int number) {
        int[] numbers = changeNumberToArray(number);
        int sum = 1;
        for (int num : numbers) {
            sum *= num;
        }
        return sum;
    }

    private int[] changeNumberToArray(int number) {
        String temp = String.valueOf(number);
        String[] split = temp.split("");
        int[] numbers = new int[split.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }

        return numbers;
    }

    public boolean validatePobiCrongBook(int[] pobi, int[] crong) {
        if (!validateBookNumber(pobi) || !validateBookNumber(crong)) {
            return false;
        }
        return true;
    }

    public boolean validateBookNumber(int[] book) {
        int leftPage = book[0];
        int rightPage = book[1];

        if (leftPage % 2 == 0) {
            return false;
        }
        if (rightPage % 2 != 0) {
            return false;
        }
        if (rightPage - leftPage != 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] pobi1 = {97, 98};
        int[] crong1 = {197, 198};

        int[] pobi2 = {131, 132};
        int[] crong2 = {211, 212};

        int[] pobi3 = {99, 102};
        int[] crong3 = {211, 212};

        System.out.println(solution4.solution(pobi1, crong1));
        System.out.println(solution4.solution(pobi2, crong2));
        System.out.println(solution4.solution(pobi3, crong3));

    }
}
