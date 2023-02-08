package programmers.파괴되지_않은_건물;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int answer = 0;
        int[][] sum = new int[board.length+1][board.length+1];
        
        for(int[] s : skill){
            int degree = s[5];
            if(s[0] == 1){ //공격
                degree = (degree*-1);
            }
            
            int r1 = s[1], c1 = s[2];
            int r2 = s[3], c2 = s[4];
            
            
            
            sum[r1][c1] += degree;
            sum[r1][c2+1] += (degree*-1);
            sum[r2+1][c1] += (degree*-1);
            sum[r2+1][c2+1] += degree;
            
        }
      
        for(int r = 1; r<board.length; r++){
            for(int c = 0; c<board.length; c++){
                sum[r][c] += sum[r-1][c];
            }
        }
        for(int c=1; c<board.length; c++){
            for(int r = 0; r<board.length; r++){
                sum[r][c] += sum[r][c-1];
            }
        }
        
        
        for(int r = 0; r<board.length; r++){
            for(int c =0; c<board.length; c++){
                if(sum[r][c] + board[r][c] > 0) answer++;
            }
        }
        
        return answer;
    }
    
}