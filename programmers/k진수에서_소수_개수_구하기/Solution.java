import java.util.*;
import java.lang.Math;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();
        int num = n;
        while(num>=k){
            list.add(num % k);
            num /= k;
        }
        list.add(num);
        String snum="";
        for(int i=list.size()-1; i>=0; i--){
            snum += Integer.toString(list.get(i));
        }
        String[] arr = snum.split("0");
        for(String s : arr){
            if(!s.equals("") && isPrime(Long.parseLong(s))){
                answer++;
            }
        }

        return answer;
    }
    
    private boolean isPrime(long n){
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}