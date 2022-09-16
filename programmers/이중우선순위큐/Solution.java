import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //작은 값이 위
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder()); // 큰 값이 위
        
        for(String s : operations){
            String[] o = s.split(" ");
            if(o[0].equals("I")){
                int num = Integer.parseInt(o[1]);
                
                pq.add(num);
                rpq.add(num);
            }else if(!pq.isEmpty()){//D
                if(o[1].equals("-1")){
                    int n = pq.poll();
                    rpq.remove(n);
                }else {
                    int n = rpq.poll();
                    pq.remove(n);
                }
            }
            
        }
        
        if(pq.isEmpty()) return new int[]{0,0};
        else{
            int[] answer = new int[2];
            answer[0] = rpq.peek();
            answer[1] = pq.peek();

            return answer;
        }
        
    }
}