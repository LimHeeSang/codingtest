package programmers.level1;

//level1-48 콜라츠 추측
class Solution48 {
    public int solution(long num) {
        int count = 0;

        while(num != 1){
            num = num%2 == 0 ? num/2 : num*3 + 1;

            if(count++ == 500){
                return -1;
            }
        }

        return count;
    }
}
