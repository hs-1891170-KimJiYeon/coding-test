class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        for(int i = 0; i< computers.length;i++){
            if(!visited[i]){
                answer++;
                dfs(i, visited, computers);
            }
        }
        
        return answer;
    }

    private void dfs(int cpt, boolean[] visited, int[][] computers){
        visited[cpt] = true;
        for(int i = 0; i< computers.length; i++){
            if(!visited[i] && computers[cpt][i]==1){
                dfs(i, visited, computers);
            }
        }
        

    }
}