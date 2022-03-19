
class Solution {
    public int solution(String s) {

        int answer = s.length();
        int len = s.length();
        for(int i = 1; i< len/2+2; i++){
            int cnt = 1;
            String cur = s.substring(0, i);
            StringBuilder str = new StringBuilder();
            for(int j = i; j < len+1; j+=i){
                String next = s.substring(j, i+j > len ? len : j+i);
                if (cur.equals(next))
                    cnt++;
                else{
                    str.append((cnt == 1 ? "" : cnt) + cur);
                    cur = next;
                    cnt = 1;
                }
            }
            str.append(cur);
            answer = Math.min(answer, str.length());
        }



        return answer;
    }
}