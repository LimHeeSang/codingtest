package programmers.level1;

//level1-47 최대공약수와 최소공배수
class Solution47 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int x = 0;  //최대 공약수
        int y = n*m;  //최소 공배수

        int temp = 0;
        if(m > n){
            temp = m;
            m = n;
            n = temp;
        }

        int l = 0;
        while(m != 0){
            l = n;
            n = m;
            m = l % m;
        }

        x = n;
        y /= x;

        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}
