package programmers.level1;

//level1-50 하샤드 수
class Solution50 {
    public boolean solution(int x) {
        int temp = x;

        int sum = 0;
        while(x != 0){
            sum += x%10;
            x /= 10;
        }

        return temp%sum == 0 ? true : false;
    }
}