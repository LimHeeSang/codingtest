package programmers.sort;
import java.util.*;

//sort1 가장 큰 수
class Sort1 {
    public String solution(int[] numbers) {
        String answer = "";

        List<String> list = new LinkedList<>();
        for(int n : numbers){
            list.add(String.valueOf(n));
        }

        list.sort(new Comparator<String>(){
            public int compare(String s1, String s2){
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String l : list){
            sb.append(l);
        }

        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
