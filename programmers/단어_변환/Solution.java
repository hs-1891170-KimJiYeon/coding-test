import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {

        ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(words));

        //타겟 단어 미포함시
        if(!Arrays.asList(words).contains(target)) return 0;

        boolean[] visited = new boolean[words.length];
        return dfs(begin, target, words, visited, 0);
    }

    private int dfs(String current, String target, String[] words, boolean[] visited, int cnt){

        int answer = words.length;
        if(current.equals(target)) return cnt;

        for(int i=0; i< words.length; i++){
            String next = words[i];
            if(!visited[i] && check(current, next)) {
                cnt++;
                visited[i]=true;
                answer=Math.min(dfs(next, target, words, visited, cnt), answer);
                visited[i]=false;
                cnt--;
            }
        }

        return answer;

    }

    private boolean check(String current, String next){
        int count=0;
        for(int i=0; i<current.length(); i++){
            if (current.charAt(i)==next.charAt(i)) count++;
        }
        if(count==current.length()-1) return true;
        else return false;
    }
}