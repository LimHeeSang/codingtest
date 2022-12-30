package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 신고 결과 받기
 */
public class Solution12 {
    public List<Integer> solution(String[] id_list, String[] reports, int k) {
        int[] answer = {};

        Map<String, Integer> reportedCount = new HashMap<>();
        Map<String, List<String>> reportOtherUsers = new LinkedHashMap<>();

        for(String id : id_list){
            reportedCount.put(id, 0);
            reportOtherUsers.put(id, new ArrayList<>());
        }

        List<String> stoppedIds = new ArrayList<>();
        for(String report : reports){
            String[] split = report.split(" ");
            //from이 to에게 신고
            String from = split[0];
            String to = split[1];

            //이미 신고한 적 있다면 생략
            List<String> list = reportOtherUsers.get(from);
            if(list.contains(to)){
                continue;
            }

            reportedCount.put(to, reportedCount.get(to) + 1);
            if(reportedCount.get(to) >= k){
                stoppedIds.add(to);
            }

            reportOtherUsers.get(from).add(to);
        }

        List<Integer> result = new ArrayList<>();
        for(List<String> reportOtherUser : reportOtherUsers.values()){
            int count = 0;
            for(String user : reportOtherUser){
                if(stoppedIds.contains(user)){
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }
}
