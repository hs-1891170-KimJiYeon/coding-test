package programmers.무인도_여행;
import java.util.*;
class Solution {
    int row, column;
    int[][] map;
    boolean[][] check;
    int[] xdir = {0, 0, -1, 1};
    int[] ydir = {-1, 1, 0, 0};
    
    
    private int bfs(int x, int y){
        int result = map[x][y];
        for(int i=0; i<4; i++){
            int nx = x + xdir[i];
            int ny = y + ydir[i];
            
            if(nx >= 0  && ny >= 0 && nx < row && ny < column){
                if(check[nx][ny] == false && map[nx][ny] > 0){
                    check[nx][ny] = true;
                    result += bfs(nx, ny);
                    
                }
            }
        }
        return result;
    }
    
    public int[] solution(String[] maps) {
        row = maps.length;
        column = maps[0].length();
        map = new int[row][column];
        check = new boolean[row][column];
        for(int i=0; i<row; i++){
            int j=0;
            for(char c : maps[i].toCharArray()){
                if(c == 'X'){
                    map[i][j]=-1;
                }else{
                    map[i][j] = c-'0';
                }
                j++;
            }   
        }
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                
                if(check[i][j] == true || map[i][j] < 0) continue;
                
                check[i][j] = true;
                int island = bfs(i, j);
                if(island != 0) answer.add(island);
                
            }
        }
        if(answer.isEmpty()) return new int[]{-1};
        
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}