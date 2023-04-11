package programmers.혼자서_하는_틱택토;

class Solution {
    char[][] boardArr;

    public int solution(String[] board) {
        boardArr = new char[3][3];
        int oCount = 0, xCount = 0;
        boolean oWin = false, xWin = false;

        for(int i=0; i<3; i++){
            boardArr[i] = board[i].toCharArray();
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                char c = boardArr[i][j];
                if(c=='.') continue;

                if(c == 'O') oCount++;
                else if(c=='X') xCount++;

                if(wCheck(i, j) || hCheck(i, j) || cCheck(i, j)){
                    if(c == 'O') oWin = true;
                    else xWin = true;
                }

            }
        }

        if(oWin && xWin) return 0; //둘 다 이길 수 없음
        if(oCount - xCount == 0 || oCount - xCount == 1){ //O선공 조건
            if(oWin && oCount == xCount) return 0; //O가 이길 때는 O의 개수가 무조건 많아야 함
            else if(xWin && oCount != xCount) return 0; //X가 이길 때는 둘의 개수가 같아야 함
            else return 1;
        }else return 0;
        

    }

    private boolean wCheck(int r, int c){ //가로 승리조건
        if(c != 0) return false;

        char attack = boardArr[r][c];
        for(int i=1; i<3; i++){
            if(boardArr[r][i] != attack) return false;
        }

        return true;
    }

    private boolean hCheck(int r, int c){ //세로 승리조건
        if(r != 0) return false;
        char attack = boardArr[r][c];
        for(int i=1; i<3; i++){
            if(boardArr[i][c] != attack) return false;
        }

        return true;
    }

    private boolean cCheck(int r, int c){ //대각선 승리조건
        if(r != 0 || c == 1) return false;
        char attack = boardArr[r][c];

        int add;
        if(c == 0) add = 1;
        else add = -1;

        for(int i=1; i<3; i++){
            c+=add;
            if(boardArr[i][c] != attack) return false;
        }

        return true;
    }
}
