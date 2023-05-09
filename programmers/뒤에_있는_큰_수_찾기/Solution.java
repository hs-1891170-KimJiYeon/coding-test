package programmers.뒤에_있는_큰_수_찾기;

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<numbers.length; i++){
            
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
               answer[stack.pop()] = numbers[i]; 
            }
            stack.push(i);
        }
        
        
        return answer;
    }
}
