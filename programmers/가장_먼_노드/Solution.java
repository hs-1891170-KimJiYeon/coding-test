import java.util.*;
class Solution{
    public int solution(int n, int[][] edge) {
        int answer = 0;

        boolean[] visited = new boolean[n]; //방문 여부
        boolean[][] checkEdge = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i< edge.length; i++){
            checkEdge[edge[i][0]-1][edge[i][1]-1] = true;
            checkEdge[edge[i][1]-1][edge[i][0]-1] = true;
        }
        queue.add(0);
        int size = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i=0; i<size; i++){
                int node = queue.poll();
                visited[node] = true;
                for(int j=0; j<n; j++){
                    if(!visited[j]&&checkEdge[node][j]){
                        visited[j]=true;
                        queue.add(j);
                    }
                }
            }
        }

        return size;
    }
}