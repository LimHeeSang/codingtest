package programmers.heap;
import java.util.*;

//heap2 디스크 컨트롤러
class Heap2 {
    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, new Comparator<int[]>(){

            public int compare(int[] arr1, int[] arr2){
                return arr1[0] - arr2[0];
            }
        });

        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                return arr1[1] - arr2[1];
            }
        });

        int count = 0;
        int end = 0;
        int jobIdx = 0;

        while(count < jobs.length){

            while(jobIdx < jobs.length && jobs[jobIdx][0] <= end){
                pq.offer(jobs[jobIdx++]);
            }

            if(pq.isEmpty()){
                end = jobs[jobIdx][0];
            }else{
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }

        return answer/jobs.length;
    }
}
