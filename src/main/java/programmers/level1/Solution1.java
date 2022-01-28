package programmers.level1;

//level1-1 로또의 최고 순위와 최저 순위
class Solution1 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int count1 = 0; //같은 것의 개수
        int count2 = 0; //0의 개수
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0){
                count2++;
                continue;
            }

            for(int j=0; j< win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    count1++;
                }
            }
        }

        int result1 = (count1 + count2);    //최고순위 일치 개수
        int result2 = count1;   //최저순위 일치개수

        answer[0] = calculation(result1);   //최고 순위
        answer[1] = calculation(result2);   //최저 순위


        return answer;
    }

    public static int calculation(int result){
        switch(result){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}