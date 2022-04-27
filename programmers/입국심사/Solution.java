import java.util.*;
class Solution {
   public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long left = 1;
        long right = (long)n * times[times.length-1];


        while(left <= right){
            long sum=0;
            long mid = (left + right) / 2;
            for(int i : times) sum += mid / i;
            if(sum < n){
                left = mid + 1;
            }else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}