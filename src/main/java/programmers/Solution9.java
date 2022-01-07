package programmers;

//level1-9 소수 만들기
class Solution9 {
    public int solution(int[] nums) {
        int count = 0;

        int sum = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    sum = nums[i] + nums[j] + nums[k];
                    if(checkSosu(sum))
                        count++;
                }
            }
        }

        return count;
    }

    public boolean checkSosu(int sum){
        for(int i=2; i<sum; i++){
            if(sum % i == 0){
                return false;
            }
        }
        return true;
    }

}
