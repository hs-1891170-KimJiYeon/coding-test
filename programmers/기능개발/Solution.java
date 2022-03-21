import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int count = 1;

        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> complete = new LinkedList<>();

        //완료 일 수 계산
        for(int i = 0; i < progresses.length; i++){
            int p = progresses[i]; int s = speeds[i];
            int cmp = (100-p)/s;
            if((100-p)%s > 0) cmp++;
            complete.add(cmp);

        }

        int pre = complete.poll();
        while(!complete.isEmpty()){
            if(complete.peek()<=pre){
                count++;
                complete.remove();
            }else{
                result.add(count);
                count = 1;
                pre = complete.poll();
            }
        }
        result.add(count);
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}