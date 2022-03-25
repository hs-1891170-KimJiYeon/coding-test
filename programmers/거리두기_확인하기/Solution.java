import java.util.*;
class Solution {
    public int[] solution(String[][] places) {

        int[] answer = new int[places.length];

        for(int i = 0; i<places.length; i++){
            boolean result = findP(places[i]);
            if(result) answer[i] = 1;
            else answer[i] = 0;
        }


        return answer;
    }

    private boolean findP(String[] arr){

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length(); j++){
                if(arr[i].charAt(j)=='P'){
                    if(!bfs(arr, i, j)) return false;

                }
            }
        }
        return true;

    }

    private boolean bfs(String[] arr, int x, int y){
        Queue<Point> q = new LinkedList<>();
        int len = arr.length;
        boolean[][] visited = new boolean[len][len];
        int[][] dir = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        visited[x][y] = true;

        q.offer(new Point(x, y));
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<dir.length; i++){
                int nx = p.x + dir[i][0];
                int ny = p.y + dir[i][1];
                int m = Math.abs(x - nx) + Math.abs(y - ny);

                if(nx < 0 || nx >= len || ny < 0 || ny >= len) continue;
                if(visited[nx][ny] || m > 2) continue;

                visited[nx][ny] = true;
                if(arr[nx].charAt(ny) == 'X') continue;
                else if(arr[nx].charAt(ny)=='P') return false;
                else q.offer(new Point(nx, ny));


            }
        }
        return true;

    }

    public class Point{
        int x; int y;
        public Point(int x, int y){
            this.x = x; this.y = y;
        }
    }
}