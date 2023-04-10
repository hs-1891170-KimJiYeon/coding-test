import java.util.*;
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int[][] distance;
    char[][] map;
    static Point start, lever, end;
    static int[] xdir = {-1, 1, 0, 0};
    static int[] ydir = {0, 0, -1, 1};
    public int solution(String[] maps) {
        int answer = 0;

        distance = new int[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            char[] arr = maps[i].toCharArray();
            for(int j=0; j<arr.length; j++){
                char c = arr[j];
                map[i][j] = c;

                if(c=='S') start = new Point(i, j);
                else if(c=='L') lever = new Point(i, j);
                else if(c == 'E') end = new Point(i, j);

            }
        }


        return bfs(map, distance);
    }

    private int bfs(char[][] map, int[][] distance) {
        int leverDis = -1;
        int lx = -1, ly = -1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        //start -> lever 
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + xdir[i];
                int ny = p.y + ydir[i];
                if( nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == 'X' || distance[nx][ny] > 0) continue;
                queue.offer(new Point(nx, ny));
                distance[nx][ny] = distance[p.x][p.y] + 1;

                
                if (map[nx][ny] == 'L') {
                    leverDis = distance[nx][ny];
                    lx = nx;
                    lx = ny;
                    break;
                }

            }

        }
        
        //레버까지 가는 길이 막혀있으면 
        if(lx == -1 && ly == -1) return -1;

        //lever -> end
        //초기화
        distance = new int[map.length][map[0].length];
        distance[lever.x][lever.y] = leverDis;
        queue = new LinkedList<>();
        queue.offer(lever);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + xdir[i];
                int ny = p.y + ydir[i];
                if( nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == 'X' || distance[nx][ny] > 0) continue;

                queue.offer(new Point(nx, ny));
                distance[nx][ny] = distance[p.x][p.y] + 1;


            }
        }
        return distance[end.x][end.y] == 0 ? -1 : distance[end.x][end.y];
    }
}