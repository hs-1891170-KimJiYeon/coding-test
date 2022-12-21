import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); //철수가 가진 토핑 종류 개수와 종류 별 개수를 알기 위해
        Stack<Integer> stack = new Stack<>(); // 토핑 나누는 범위를 순서대로 하기 위해
        HashSet<Integer> set = new HashSet<>(); //동생이 가진 토핑 종류 개수 확인
        
        for(int i=0; i<topping.length; i++){
            int to = topping[i];
            if(i == topping.length-1){ // 제일 끝에있는 토핑은 동생
                set.add(to);
            }else{
                //마지막 토핑 제외한 모두 철수가 가지고 있는 것으로 초기 설정
                map.put(to, map.getOrDefault(to, 0)+1); 
                stack.push(to);
            }
        }
        while(!stack.isEmpty()){
            int to = stack.pop(); //넘겨줄 토핑 
            map.put(to, map.get(to)-1);
            set.add(to); // 동생에게 넘김
            if(map.get(to)==0){
                map.remove(to);
            }
            //철수가 가진 토핑 종류의 개수와 동생이 가진 토핑 종류 개수가 같으면 공평함
            if(map.size() == set.size()){
                answer++;
            }
            
        }
        
        return answer;
    }
}