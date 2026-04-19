class Solution {
    //TC=0(N^2)
    public boolean wordBreak(String s, List<String> wordDict) {
       Set<String>dict=new HashSet<>(wordDict);
       Boolean[]dp=new Boolean[s.length()]; //Store repeating cases
       return helper(s,dict,0,dp);
    }
       private boolean helper(String s,Set<String>dict,int start, Boolean[] dp){
        if(start==s.length()) return true;
        if(dp[start]!=null) return dp[start];//means it has been calculated
        for(int end=start+1;end<=s.length();end++){
            String part=s.substring(start,end);
            if(dict.contains(part)){
                if(helper(s,dict,end,dp)){
                    return dp[start]=true; //mark(store) start =true if start found
                }
            }
        }
        return dp[start]=false; //mark(store) the result of dp[start]
       }
}
    
