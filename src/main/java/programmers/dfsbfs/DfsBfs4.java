package programmers.dfsbfs;
import java.util.*;

//dfsbfs4 여행경로
class DfsBfs4 {
    public String[] solution(String[][] tickets) {
        String[] answer;

        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];

        String start = "ICN";
        dfs(tickets, result, visited, start, start, 0);

        Collections.sort(result);
        answer = result.get(0).split(" ");


        return answer;
    }

    public void dfs(String[][] tickets, List<String> result, boolean[] visited, String temp, String start, int count){
        if(count == tickets.length){
            result.add(temp);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets, result, visited, temp + " " + tickets[i][1], tickets[i][1], count+1);
                visited[i] = false;
            }
        }
    }


}