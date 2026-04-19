class Solution {
    //TC=0(N^2)
    public boolean wordBreak(String s, List<String> wordDict) {
       Set<String>dict=new HashSet<>(wordDict);
       Boolean[]dp=new Boolean[s.length()]; //Stores result of subproblems
       return helper(s,dict,0,dp);
    }
       private boolean helper(String s,Set<String>dict,int start, Boolean[] dp){
        if(start==s.length()) return true;
        if(dp[start]!=null) return dp[start];//means it has been calculated,reuse this result
        for(int end=start+1;end<=s.length();end++){
            String part=s.substring(start,end);
            if(dict.contains(part)){
                if(helper(s,dict,end,dp)){
                    return dp[start]=true; //mark start as true since valid partition found
                }
            }
        }
        return dp[start]=false; //mark start as false since no valid partition found 
       }
}
    
// dp[start] depends on dp[end], so overlapping subproblems are avoided using memoization