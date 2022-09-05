package programmers.level2;

public class Solution6 {

    private int count = 0;

    public int solution(int n) {

        for(int i=1; i<= n; i++){
            calculate(n, i);
        }

        return count;
    }

    public void calculate(int n, int start){
        int preNum = start + 1;
        while(start < n){
            start += preNum;
            preNum++;
        }
        if(start == n){
            count++;
        }
    }
}
