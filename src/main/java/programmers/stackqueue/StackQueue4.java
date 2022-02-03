package programmers.stackqueue;

//stackqueue4 주식가격
class StackQueue4 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        int time = 0;
        int idx = 0;
        for(int i=0; i<prices.length; i++){
            time = 0;
            for(int j=i+1; j<prices.length; j++){


                time++;
                if(prices[i] > prices[j]) break;

            }
            answer[idx++] = time;
        }

        return answer;
    }
}
