import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) {
            pq.add(i);
        }
        while(pq.peek() < K){
            int f = pq.poll();
            if(pq.isEmpty()) return -1;
            int mix = mixScovile(f, pq.poll());
            pq.add(mix);
            answer++;
        }



        return answer;
    }

    private int mixScovile(int first, int second) {
        return first + (second * 2);
    }
}