import java.util.*;
class Solution {
    public static boolean[] visited;
    public static ArrayList<String> route;
    public static String r = "";
    public String[] solution(String[][] tickets) {

        String[] answer = {};
        route = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        dfs("ICN",  tickets, 0);
        Collections.sort(route);
        answer = route.get(0).split(" ");
        
        return answer;

    }

    private void dfs(String start, String[][] tickets, int cnt){
        r += start + " ";
        if(cnt == tickets.length) {
            route.add(r);
            return;
        }
        
        for(int i=0; i< tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                
                String dst = tickets[i][1];
                visited[i]=true;
                cnt++;
                dfs(dst, tickets, cnt);
                r = r.substring(0, r.length()-4);
                visited[i] = false;
                cnt--;
                
            }
        }

    }

}