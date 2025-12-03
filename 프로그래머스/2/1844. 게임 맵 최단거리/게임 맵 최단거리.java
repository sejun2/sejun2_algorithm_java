import java.util.*;
import java.math.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    int step = 1;
    boolean reached = false;
    
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        // dfs(visited, maps, 0,0, 0);
        bfs(visited, maps, 0, 0);
       
        if(!reached) return -1;
        
        return step;
        
        //if(answer == Integer.MAX_VALUE) return -1;
        
        //return answer;
    }
    
    void bfs(boolean[][] visited, int[][] maps, int currentX, int currentY){
       Queue<Integer[]> q = new LinkedList<>(); 
        
       q.add(new Integer[]{currentX, currentY, 1});
       visited[currentX][currentY] = true;
        
        while(!q.isEmpty()){
            Integer[] axis = q.poll();
            
            if(axis[0] == maps.length - 1 && axis[1] == maps[0].length - 1){
                // 목적지 도달
                reached = true;
                step = axis[2];
                return;
            }
            
            for(int i =0 ;i<4; i++){
                int nextX = axis[0] + dx[i];
                int nextY = axis[1] + dy[i];
                int nextStep = axis[2] + 1;
                
                if(nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) continue;
                
                if(maps[nextX][nextY] == 0) continue;
                
                if(visited[nextX][nextY]) continue;
                
       			visited[nextX][nextY] = true;
                q.add(new Integer[] {nextX, nextY, nextStep});
            }
        }
    }
    
    void dfs(boolean[][] visited, int[][] maps, int currentX, int currentY,  int step){
        if(currentX <0 || currentX > maps.length -1 || currentY > maps[0].length -1 || currentY < 0) return;
        
        if(maps[currentX][currentY] == 0) return;
        
        if(visited[currentX][currentY]) return;
        
       	if(currentX == maps.length-1 && currentY == maps[0].length-1) {
            // 목적지 도달
            answer = Math.min(answer, step+1);
            return;
        }
        
        visited[currentX][currentY]  = true;
        step++;
       
        for(int i =0;i<4;i++){
          dfs(visited, maps, currentX + dx[i], currentY + dy[i], step);
        }
        
        visited[currentX][currentY]  = false;
        step--;
    }
}
