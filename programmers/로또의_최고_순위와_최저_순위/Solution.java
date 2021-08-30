import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<Integer>(6);
        for(int i : win_nums){
            set.add(i);
        }
        int winCount = 0;
        int zeroCount = 0;
        for(int i : lottos){

            if(set.contains(i)) winCount++;
            else if(i==0) zeroCount++;
        }
        System.out.println(winCount + " "+ zeroCount);
        int max = winCount + zeroCount;
        int min = winCount;
        int[] answer = {Math.min(7-max, 6), Math.min(7-min, 6)};
        return answer;
    }
}