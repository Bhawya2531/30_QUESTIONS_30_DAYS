class Solution {
    public int minimizedStringLength(String s) {
        boolean[]seen=new boolean[26];
        return solve(s,0,seen);

    }
    private int solve(String s, int index, boolean[]seen){
        if(index==s.length()){
            return 0;
        }
        char ch=s.charAt(index);
        int idx=ch-'a';
        if(seen[idx]){
            return solve(s,index+1,seen);
        }
        seen[idx]=true;
        return 1+solve(s,index+1,seen);
    }
}
