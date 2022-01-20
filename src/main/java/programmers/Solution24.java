package programmers;

//level1-24 [1차] 비밀지도
class Solution24 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        int[] result1 = arrayIntToBinary(arr1, n);
        int[] result2 = arrayIntToBinary(arr2, n);

        String temp = "";
        int count = 0;
        for(int i=0; i<result1.length; i++){

            if(result1[i]==0 && result2[i] == 0){
                temp += " ";
            }else{
                temp += "#";
            }

            if(i%n == n-1){
                answer[count++] = temp;
                temp = "";
            }
        }


        return answer;
    }

    public int[] arrayIntToBinary(int[] arr, int n){

        int[] result = new int[n*n];

        for(int i=0; i<arr.length; i++){
            String str = intToBinaryString(arr[i], n);

            String[] temp = str.split("");

            int k=0;
            for(int j=i*n; j<temp.length*(i+1); j++){
                result[j] = Integer.parseInt(temp[k++]);
            }
        }

        return result;

    }

    public String intToBinaryString(int num, int n){
        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.append(num%2);
            num /= 2;
        }

        String temp = sb.reverse().toString();
        while(temp.length()<n){
            temp = "0" + temp;
        }

        return temp;
    }


}