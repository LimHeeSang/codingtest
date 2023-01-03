package programmers.greedy;

/**
 * 큰 수 만들기
 */
public class Greedy1 {

    public String solution(String number, int k) {

        String[] split = number.split("");
        int[] arr = new int[split.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(split[i]);
        }

        int[] answer = new int[arr.length - k];

        int startIdx = 0;
        int lastIdx = arr.length - answer.length;
        for(int i=0; i<answer.length; i++){
            int max = -1;
            int idx = 0;

            for(int j=startIdx; j<= lastIdx; j++){
                if(max < arr[j]){
                    max = arr[j];
                    idx = j;
                }
            }
            answer[i] = arr[idx];
            startIdx = idx + 1;
            lastIdx++;
        }

        StringBuilder sb = new StringBuilder();
        for(int a : answer){
            sb.append(a);
        }
        return sb.toString();
    }
}
