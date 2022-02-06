package programmers.bruteforce;

//bruteforce2 카펫
class BruteForce2 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = 0;
        int height = 0;

        int tempB = 0;
        int tempY = 0;

        for(int i=1; i<=yellow; i++){
            tempY = yellow;
            if(tempY%i != 0) continue;
            tempY /= i;

            tempB = (tempY * 2) + 4 + (i * 2);

            width = tempY + 2;
            height = i + 2;

            if(tempB == brown && width >= height){
                break;
            }
        }

        answer[0] = width;
        answer[1] = height;

        return answer;
    }
}