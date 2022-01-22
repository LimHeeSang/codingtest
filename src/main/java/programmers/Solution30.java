package programmers;
import java.util.*;

//level1-30 문자열 내 마음대로 정렬하기
class Solution30 {
    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char ch1 = o1.charAt(n);
                char ch2 = o2.charAt(n);

                if (ch1 > ch2) return 1;
                else if(ch1 < ch2) return -1;
                else{
                    for(int i=0; i<o1.length(); i++){
                        if(o1.charAt(i) > o2.charAt(i)) return 1;
                        else if(o1.charAt(i) < o2.charAt(i)) return -1;
                    }

                }
                return 0;
            }
        });

        return strings;
    }
}
