package programmers.level2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution9 {

    public int[] solution(int brown, int yellow) {
        //yellow의 약수개산 함수
        //yellow의 가로, 세로 크기를 기반으로 brown 총 수를 계산하여 매개변수 brown과 같다면 해당 yellow 가로, 세로가 정답

        //yellow와 brown의 개수가 주어졌을대 사각형의 가로 세로 계산하는 함수
        List<int[]> yellows = calculateYaksu(yellow);

        int resultYellowWidth = 0;
        int resultYellowHeight = 0;
        for (int[] yellowPair : yellows) {
            if (calculateBrownCount(yellowPair) == brown) {
                resultYellowWidth = yellowPair[0];
                resultYellowHeight = yellowPair[1];
            }
        }

        return calculateWidhtAndHegith(resultYellowWidth, resultYellowHeight);
    }

    private int[] calculateWidhtAndHegith(int yellowWidth, int yellowHeight) {
        int width = yellowWidth + 2;
        int height = yellowHeight + 2;
        return new int[]{width, height};
    }

    private int calculateBrownCount(int[] yellow) {
        int width = yellow[0];
        int height = yellow[1];
        return (width + 2) * 2 + height * 2;
    }

    private List<int[]> calculateYaksu(int n) {
        //yellow의 약수가 가로 세로의 경우의 수가 될 수 있음
        //yellow의 가로는 세로보다 같거나 같음.
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int width = Math.max(i, n / i);
                int height = Math.min(i, n / i);
                result.add(new int[]{width, height});
            }
        }
        return result;
    }
}
