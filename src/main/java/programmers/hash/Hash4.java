package programmers.hash;
import java.util.*;

//hash4 베스트앨범
class Hash4 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;

        Map<String, Integer> map = new HashMap<>(); //장르, 플레이수
        List<Music> list = new LinkedList<>();  //음악 인덱스, 장르, 플레이수


        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            list.add(new Music(i, genres[i], plays[i]));
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2){
                return m2.getValue() - m1.getValue();
            }
        });

        List<String> genreOrder = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList){
            genreOrder.add(entry.getKey());
        }

        Collections.sort(list);

        List<Integer> tempList = new ArrayList<>();
        for(String genre : genreOrder){
            int count = 0;

            for(int i=0; i<list.size(); i++){
                Music m = list.get(i);
                if(m.genre.equals(genre)){
                    tempList.add(m.idx);
                    count++;
                }
                if(count == 2) break;
            }
        }


        answer = new int[tempList.size()];
        for(int i=0; i<tempList.size(); i++){
            answer[i] = tempList.get(i);
        }


        return answer;
    }

    static class Music implements Comparable<Music>{
        int idx;
        String genre;
        int play;

        Music(int idx, String genre, int play){
            this.idx = idx;
            this.genre = genre;
            this.play = play;
        }

        public int compareTo(Music m){
            return this.play == m.play ? this.idx-m.idx : m.play-this.play;
        }
    }
}
