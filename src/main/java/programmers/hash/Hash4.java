package programmers.hash;
import java.util.*;

//hash4 베스트앨범
class Hash4 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                return o2.getValue() - o1.getValue();
            }
        });

        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList){
            list.add(entry.getKey());
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for(String s : list){
            int max = 0;
            int fir = 0;
            int sec = 0;

            for(int i=0; i<genres.length; i++){
                if(s.equals(genres[i]) && max < plays[i]){
                    max = plays[i];
                    fir = i;
                }
            }

            temp.add(fir);
            max = 0;

            for(int i=0; i<genres.length; i++){
                if(s.equals(genres[i]) && max < plays[i] && i != fir){
                    max = plays[i];
                    sec = i;
                }
            }

            if(max != 0) temp.add(sec);
        }

        answer = new int[temp.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = temp.get(i);
        }

        return answer;
    }
}
