import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Solution {

    public int solution(String name) {
        int answer = 0;


        char[] nameArr = name.toCharArray();
        ArrayList<Integer> checkA = new ArrayList<>();
        for(int i=0; i<name.length(); i++){
            if(nameArr[i] != 'A') checkA.add(i);
        }

        int cursor = 0; //현위치
        int idx =0;
        //커서 이동 횟수
        while(!checkA.isEmpty()){
            int nextC = checkA.get(idx);
            int right = Math.abs(nextC - cursor);
            int left
        }

        //알파벳 바꾸기 횟수
        for(int i=0; i<name.length(); i++){
            if(nameArr[i] == 'A') continue; //현재 알파벳이 A일 때
            int a = (int)nameArr[i] - 65; //A 까지의 거리
            int z = 90 - (int)nameArr[i] + 1; //Z 넘어서 A로 가는 거리
            answer += Math.min(a, z);

        }


        return answer;
    }


    private int cursorMoveCount(ArrayList<Integer> checkA, int cursor, int idx, int answer){
        int move = 0;

        if(checkA.isEmpty()) return answer;

        int nextCursor = checkA.get(idx);
        //오른쪽 이동

        cursorMoveCount(checkA, nextCursor, ++idx, answer);
        //왼쪽 이동
        cursorMoveCount(checkA, nextCursor, --idx, answer);

        return move;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("JEROEN"); //56
        s.solution("JAN"); //23

    }

}
