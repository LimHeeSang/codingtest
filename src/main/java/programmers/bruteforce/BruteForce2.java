package programmers.bruteforce;

//bruteforce2 카펫
class BruteForce2 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int area = brown + yellow;
        int width = 0;
        int height = 0;

        for(int i = 3; i<=Math.sqrt(area); i++){
            if(area % i != 0) continue;
            height = i;
            width = area/height;

            if(width >= height && (width - 2) * (height - 2) == yellow) break;
        }
        answer[0] = width;
        answer[1] = height;

        return answer;
    }
}