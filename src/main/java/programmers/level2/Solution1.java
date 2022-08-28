package programmers.level2;

public class Solution1 {
    public String solution(String s) {
        String answer = "";

        String[] splited = s.split(" ");
        int[] arr = new int[splited.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(splited[i]);
        }

        int max = max(arr);
        int min = min(arr);
        answer = answer.concat(String.valueOf(min)).concat(" ").concat(String.valueOf(max));

        return answer;
    }

    public int max(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    public int min(int[] arr){
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }

        return min;
    }
}
