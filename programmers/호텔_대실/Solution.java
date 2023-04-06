package programmers.호텔_대실;
import java.util.*;
class Solution {
    public int solution(String[][] book_time) {

        PriorityQueue<int[]> inQueue = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        for(String[] book : book_time){
            inQueue.offer(new int[]{changeTimeToMinute(book[0]), changeTimeToMinute(book[1])+10});
        }


        //퇴실시간 넣기
        PriorityQueue<int[]> room = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        room.offer(inQueue.poll());
        while(!inQueue.isEmpty()){
            int[] nextGuest = inQueue.poll();
            if(!room.isEmpty() && room.peek()[1] <= nextGuest[0]){
                room.poll();
            }
            room.offer(nextGuest);
        }


        return room.size();
    }

    private int changeTimeToMinute(String time){ //시간을 분으로 변환
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]);
    }
}
