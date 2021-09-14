import java.util.Stack;

class Soultion{

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int m : moves){

            int col = m-1;
            for(int i = 0; i < board.length; i++){
                int cur = board[i][col];

                if(cur != 0) {
                    if(!(stack.isEmpty()) && stack.peek()==cur){
                        answer+=2;
                        stack.pop();
                    }
                    else{
                        stack.push(cur);

                    }
                    board[i][col] = 0;
                    break;

                }

            }


        }

        return answer;
    }


}