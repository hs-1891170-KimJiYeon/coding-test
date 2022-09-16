class Solution {
    public int[] solution(int n, int s) {
        
        if(n > s) return new int[]{-1};

        int[] answer = new int[n];
        int m = s / n; //합이 s이하인 집합에서 원소들이 가질 수 있는 최소한으로 큰 숫자 / 조건에 만족하려면 원소가 m 이상의 숫자로 이루어져야함
        int t = s % n;
        for(int i=0; i<n; i++){
            
            if(n != 0 && i >= (n-t)) answer[i] = m+1; //합이 s이기 위해 부족한 수 만큼 채워줌
            else answer[i] = m;
        }
        
        
        
        return answer;
    }
}