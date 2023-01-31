import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        LinkedList<int[]> deliveryList = new LinkedList<>();
        LinkedList<int[]> pickupList = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(deliveries[i] > 0) deliveryList.add(new int[]{deliveries[i], i+1});
            if(pickups[i] > 0) pickupList.add(new int[]{pickups[i], i+1});
        }

        while(!deliveryList.isEmpty() || !pickupList.isEmpty()){
            int dist = 0;
            int box = 0;
            dist = moveBox(cap, deliveryList, dist, box);
            box = 0;

            dist = moveBox(cap, pickupList, dist, box);
            answer += (long)dist*2;



        }


        return answer;

    }

    private int moveBox(int cap, LinkedList<int[]> linkedList, int dist, int box) {
        while(!linkedList.isEmpty() && box <= cap){
            int[] d = linkedList.pollLast();
            dist = Math.max(dist, d[1]);

            if(d[0] + box <= cap){
                box += d[0];
            }else{
                d[0] -= (cap - box);
                linkedList.add(new int[]{d[0], d[1]});
                break;
            }

        }
        return dist;
    }
}