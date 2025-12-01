import java.util.*;

class Solution {
    long answer;
    
    public long solution(int n, int[] times) {
       List<Integer> timeList = new ArrayList<>();
        
       for(int i= 0; i<times.length; i++){
           timeList.add(times[i]);
       }
        timeList.sort(Collections.reverseOrder());
        
        long minTime = 1;
        long maxTime = (long) timeList.get(0) * n;
        
        answer = maxTime;
        
        while(minTime <= maxTime){
            long t = (minTime+maxTime)/2;
            long number = 0;
            
            for(int i =0 ;i<times.length; i++){
                number+=t/(long)times[i];
            }
            
            if(number >= n){
                answer = Math.min(answer, t);
                maxTime = t - 1;
            }else{
                minTime = t + 1;
            }
        }
     
        return answer;
    }
    
}