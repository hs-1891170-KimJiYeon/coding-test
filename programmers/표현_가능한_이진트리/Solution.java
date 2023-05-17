import java.util.*;
class Solution {
    static int result;
    int[] binary;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i=0; i<numbers.length; i++){
            binary = changeToBinary(numbers[i]);
            result = 1;
            dfs(0,  binary.length - 1, false);
            answer[i] = result;
        }

        return answer;
    }

    private void dfs(int startIdx, int lastIdx, boolean dummy){
        int rootIdx = (startIdx + lastIdx) / 2;
        boolean b;
        if(binary[rootIdx] == 1) b = true;
        else b = false;
        if(b && dummy) { //부모가 0일때 자식이 1이면 안됨
            result = 0;
            return;

        }

        if(startIdx != lastIdx){
            if(binary[rootIdx] == 0) dummy = true;
            else dummy = false;
            dfs(startIdx, rootIdx -1, dummy); //나 자신이 0이면 dummy ture
            dfs(rootIdx + 1, lastIdx, dummy);
        }



    }

    private int[] changeToBinary(long number){

        ArrayList<Integer> list = new ArrayList<>();
        long n = number;
        while(n > 1){
            list.add(0, (int)n%2);
            n /= 2;
        }
        list.add(0, (int)n);

        //포화이진트리가 아니면 0 추가
        int addZero = zeroCount(list.size());
        if(addZero != 0){
            for(int i=0; i<addZero; i++)
                list.add(0, 0);
        }
        return list.stream().mapToInt(i -> i).toArray();

    }

    //포화이진트리 만들기 위해 추가해야하는 0의 개수
    private int zeroCount(int length){

        int len = length;
        int level = 1;
        while(len > 0){
            len -= level;
            level *= 2;
        }
        return Math.abs(len);

    }
    
}