package programmers.level1;

//level1-44 정수 제곱근 판별
class Solution44 {
    public long solution(long n) {

        if(Math.pow((int)Math.sqrt(n), 2) == n){
            return (long)Math.pow(Math.sqrt(n)+1, 2);
        }

        return -1;
    }
}