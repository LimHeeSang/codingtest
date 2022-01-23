package programmers;

//level1-31 문자열 내 p와 y의 개수
class Solution31 {
    boolean solution(String s) {

        s = s.toLowerCase();

        int countP = 0;
        int countY = 0;

        char[] ch = s.toCharArray();
        for(char c : ch){
            if(c == 'p') countP++;
            if(c == 'y') countY++;
        }

        return countP==countY;
    }
}