package programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * 성격 유형 검사하기
 */
public class Solution13 {
    public String solution(String[] survey, int[] choices) {
        String result = "";

        List<Tuple> tuples = new ArrayList<>(); //4개의 튜블
        int[] scores = {3, 2, 1, 0, 1, 2, 3};

        String[] typeNames = {"R", "T", "C", "F", "J", "M", "A", "N"};
        for (int i = 0; i < typeNames.length; i += 2) {
            Type left = new Type(typeNames[i]);
            Type right = new Type(typeNames[i + 1]);
            tuples.add(new Tuple(left, right));
        }

        for (int i = 0; i < survey.length; i++) {
            String problem = survey[i];
            String[] split = problem.split("");
            String left = split[0];
            String right = split[1];

            int choice = choices[i];
            String answer;
            if (choice < 4) {
                answer = left;
            } else if (choice > 4) {
                answer = right;
            } else {
                continue;
            }

            for (Tuple tuple : tuples) {
                tuple.calculate(answer, scores[choice - 1]);
            }
        }

        for (Tuple tuple : tuples) {
            Type left = tuple.getLeft();
            Type right = tuple.getRight();

            if (left.score > right.score) {
                result += left.name;
            } else if (left.score < right.score) {
                result += right.name;
            } else {
                result += left.name;
            }
        }

        return result;
    }
}

class Tuple {
    Type left;
    Type right;

    Tuple(Type left, Type right) {
        this.left = left;
        this.right = right;
    }

    void calculate(String answer, int score) {
        if (left.isEqualName(answer)) {
            left.increase(score);
        }
        if (right.isEqualName(answer)) {
            right.increase(score);
        }
    }

    Type getLeft() {
        return left;
    }

    Type getRight() {
        return right;
    }
}

class Type {
    String name;
    int score;

    Type(String name) {
        this.name = name;
        score = 0;
    }

    boolean isEqualName(String name) {
        return this.name.equals(name);
    }

    void increase(int score) {
        this.score += score;
    }
}
