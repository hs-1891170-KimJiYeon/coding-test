class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        
        int sum = 0;
        for(int i = 0; i< absolutes.length; i++){
            int num = absolutes[i];
            if(!signs[i]){
                num -= (num*2);
            }
            sum += num;
        }
        return sum;
    }
}
