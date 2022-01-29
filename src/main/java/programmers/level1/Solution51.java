package programmers.level1;

//level1-51 핸드폰 번호 가리기
class Solution51 {
    public String solution(String pn) {
        StringBuilder sb = new StringBuilder();

        for(int i=pn.length()-1; i>=0; i--){
            if(i >= pn.length()-4) sb.append(pn.charAt(i));
            else sb.append("*");
        }

        return sb.reverse().toString();
    }
}
