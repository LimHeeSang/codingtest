package programmers.dfsbfs;
import java.util.*;

//dfsbfs3 단어변환
class DfsBfs3 {
    int count = 0;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean flag = false;
        List<String> list = new LinkedList<>();

        for(String word : words){
            if(word.equals(target)) flag = true;
            list.add(word);
        }
        if(flag == false) return 0;
        list.remove(target);
        list.add(0, target);

        boolean[] visited = new boolean[list.size()];

        dfs(list, visited, begin, target, 0);
        answer = count;

        return answer;
    }

    public void dfs(List<String> list, boolean[] visited, String start, String target, int depth){

        if(start.equals(target)){
            count = depth;
            return;
        }

        for(int i=0; i<list.size(); i++){
            if(!visited[i] && checkWord(start, list.get(i))){
                visited[i] = true;
                dfs(list, visited, list.get(i), target, depth+1);
                visited[i] = false;
            }
        }
    }


    public boolean checkWord(String str1, String str2){ //두 단어중 같은게 한개만 있는지 확인 or 다음으로 이동할 수 있는지
        int k = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) == str2.charAt(i)) k++;
        }

        return k == str1.length()-1 ? true : false;
    }
}
