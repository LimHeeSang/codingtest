package programmers;

import java.util.*;

//level1-5 크레인 인형뽑기 게임
class Solution5 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        //board = 인형박스
        //movew = 뽑기번호
        //box = 뽑은 인형

        List<Integer> box = new LinkedList<>();

        for(int i=0; i<moves.length; i++){

            claw(moves[i], board, box);
            answer += checkBox(box);

        }

        return answer;
    }

    public void claw(int index, int[][] board, List box){
        for(int i=0; i<board.length; i++){
            if(board[i][index-1] != 0){
                int temp = board[i][index-1];
                board[i][index-1] = 0;
                box.add(temp);
                break;
            }
        }
    }

    public int checkBox(List box){

        int count = 0;

        for(int i=0; i<box.size()-1; i++){
            if(box.get(i) == box.get(i+1)){
                box.remove(i);
                box.remove(i);
                count += 2;
                continue;
            }
        }

        return count;
    }
}