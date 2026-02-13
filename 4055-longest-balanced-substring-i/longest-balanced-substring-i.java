class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int maxlen=0;
        for(int i=0;i<n;i++){
            int[]freq=new int[26];
        for(int j=i;j<n;j++){
            freq[s.charAt(j)-'a']++;
            HashMap<Integer,Integer>map=new HashMap<>();
            for(int k=0;k<26;k++){
                if(freq[k]>0){
                    map.put(freq[k],map.getOrDefault(freq[k],0)+1);
                }
            }
            if(map.size()==1){
                maxlen=Math.max(maxlen,j-i+1);
            }
        }
        }
        return maxlen;
    }
}

                