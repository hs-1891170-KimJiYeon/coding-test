import java.util.ArrayList;
import java.util.Collections;

class Solution {
    int[][] nums;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        nums = new int[rows][columns];

        int num=1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                nums[i][j]=num++;
            }
        }
        int idx = 0;
        for(int i=0; i< queries.length; i++){
            answer[i] = rotate(queries[i]);
        }


        return answer;
    }

    private int rotate(int[] arr){
        int x1 = arr[0]-1, y1 = arr[1]-1;
        int x2 = arr[2]-1, y2 = arr[3]-1;
        int pre = nums[x1][y1];
        int min = pre;
        int tmp;
        for(int i=y1+1; i<= y2; i++){
            tmp = nums[x1][i];
            min = Math.min(min, tmp);
            nums[x1][i] = pre;
            pre = tmp;
        }

        for(int i=x1+1; i<= x2; i++){
            tmp = nums[i][y2];
            min = Math.min(min, tmp);
            nums[i][y2] = pre;
            pre = tmp;
        }

        for(int i=y2-1; i>= y1; i--){
            tmp = nums[x2][i];
            min = Math.min(min, tmp);
            nums[x2][i] = pre;
            pre = tmp;
        }

        for(int i=x2-1; i>= x1; i--){
            tmp = nums[i][y1];
            min = Math.min(min, tmp);
            nums[i][y1] = pre;
            pre = tmp;
        }
        

        return min;
    }
}