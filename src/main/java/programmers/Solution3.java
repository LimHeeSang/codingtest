package programmers;

class Solution3 {
    public int solution(String s) {
        int answer = 0;

        String[] number = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine"};

        for(int i=0; i<number.length; i++){
            s = s.replaceAll(number[i], String.valueOf(i));
        }

        answer = Integer.parseInt(s);
        return answer;
    }
}
