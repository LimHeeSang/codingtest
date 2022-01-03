package programmers;

class Solution4 {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        int left = 10;   //이전 왼손 위치
        int right = 11;  //이전 오른손 위치
        //하나씩 검사하여 answer에 L인지 R인지 추가
        for(int num : numbers){

            //num이 1, 4, 7일경우 왼손
            if(num==1 || num==4 || num==7){
                answer += "L";
                left = num;
            }else if(num == 3 || num==6 || num==9){ //num이 3, 6, 9일경우 왼손
                answer += "R";
                right = num;
            }else{  //num이 2, 5, 8, 0일 경우
                String temp = distCalculate(num, left, right, hand);
                answer += temp;
                if(temp.equals("R")) right = num;
                else left = num;
            }
        }


        return answer;
    }

    public static String distCalculate(int num, int left, int right, String hand){
        int[][] map = new int[][]{
                {3, 1}, {0, 0}, {0, 1},
                {0, 2}, {1, 0}, {1, 1},
                {1, 2}, {2, 0}, {2, 1},
                {2, 2}, {3, 0}, {3, 2}
        };


        int leftDist = (Math.abs(map[num][0]-map[left][0])) + (Math.abs(map[num][1]-map[left][1]));
        int rightDist = (Math.abs(map[num][0]-map[right][0])) + (Math.abs(map[num][1]-map[right][1]));

        if(leftDist > rightDist){
            return "R";
        }else if(leftDist < rightDist){
            return "L";
        }else{
            if(hand.equals("left"))
                return "L";
            else
                return "R";

        }

    }

}