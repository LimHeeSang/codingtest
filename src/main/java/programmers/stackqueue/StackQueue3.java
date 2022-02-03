package programmers.stackqueue;

import java.util.*;

//stackqueue3 다리를 지나는 트럭
class StackQueue3 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;

        LinkedList<Truck> bridge = new LinkedList<>();   //다리를 건너는 트럭
        Queue<Truck> list = new LinkedList<>(); //대기 트럭

        for(int w : truck_weights){
            list.add(new Truck(w, bridge_length));
        }

        bridge.offer(list.poll());
        time++;

        int sum;
        while(!bridge.isEmpty()) {
            //다리에 있는 트럭의 건너야할 다리길이 1씩 배주기
            sum = 0;
            for(Truck t : bridge){
                t.length -= 1;
            }

            if(bridge.peek().length == 0){
                bridge.poll();
            }

            //현재 다리에 있는 트럭의 총 무게 계산
            for(Truck t : bridge){
                sum += t.weight;
            }

            if(!list.isEmpty() && (sum + list.peek().weight) <= weight && bridge.size()+1 <= bridge_length){
                bridge.offer(list.poll());
            }

            time++;
        }

        return time;
    }

    static class Truck{
        int weight;
        int length;

        Truck(int weight, int length){
            this.weight = weight;
            this.length = length;
        }
    }
}
