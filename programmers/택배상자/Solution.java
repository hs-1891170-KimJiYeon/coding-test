import java.util.*;
class Solution {
    public int solution(int[] order) {
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> truck = new ArrayList<>();
        int idx = 0;
        
        for(int box=1; box<=order.length; box++){
            if(box == order[idx]){
                truck.add(box);
                idx++;
            }
            else{
                stack.push(box);
            }
            
            if(!stack.isEmpty() && stack.peek() != box){
                if(stack.peek() == order[idx]){
                    truck.add(stack.pop());
                    idx++;
                }
                
            }
            
        }
        
        while(idx<order.length && !stack.isEmpty()){
            if(stack.peek() == order[idx]) {
                truck.add(stack.pop());
                idx++;
            }
            else break;
        }
        
        
        
        
        return truck.size();
    }

    //다른사람 풀이
    // class Solution {
        // public int solution(int[] order) {
            
        //     Stack<Integer> stack = new Stack<>();
        //     ArrayList<Integer> truck = new ArrayList<>();
        //     int idx = 0;
            
        //     for(int box=1; box<=order.length; box++){
                
        //         stack.push(box);
                
        //         while(!stack.isEmpty()){
                    
        //             if(stack.peek() == order[idx]){
        //                 truck.add(stack.pop());
        //                 idx++;
        //             }else{
        //                 break;
        //             }
                    
        //         }
        //     }
            
        //     return truck.size();
        // }
    // }
}
