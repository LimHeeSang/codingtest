package programmers.level2;

public class Solution3 {
    private int countChange = 0;
    private int countZero = 0;

    public int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")){
            s = change(s);
        }
        answer[0] = countChange;
        answer[1] = countZero;

        return answer;
    }

    public String change(String s){
        countChange++;

        String[] splited = s.split("");
        int[] arr = new int[splited.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(splited[i]);
        }

        int oneLength = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                countZero++;
            }else{
                oneLength++;
            }
        }

        return Integer.toBinaryString(oneLength);
    }
}
