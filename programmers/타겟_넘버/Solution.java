class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int num = numbers[0];
        answer += dfs(num, numbers, 0, target);
        answer += dfs(-num, numbers, 0, target);
        return answer;
    }

    private int dfs(int num, int[] numbers, int idx, int target){

        if(idx == numbers.length-1){
            if(num == target)
                return 1;
            else return 0;
        }
        idx++;
        int next = numbers[idx];
        int sum =0;
        sum += dfs(num + next, numbers, idx, target);
        sum += dfs(num - next, numbers, idx, target);

        return sum;


    }
}