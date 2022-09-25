package programmers.level2;

public class Solution8 {

    public int solution(int n) {
        int answer = 0;

        int bigNumber = n + 1;
        while(answer == 0){
            if(countBinaryOne(n) == countBinaryOne(bigNumber)){
                answer = bigNumber;
            }
            bigNumber++;
        }

        return answer;
    }

    public int countBinaryOne(int n){
        int count = 0;
        while(n != 0){
            if(n % 2 == 1){
                count++;
            }
            n /= 2;
        }

        return count;
    }
}
