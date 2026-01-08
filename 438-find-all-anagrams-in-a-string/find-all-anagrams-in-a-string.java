class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=p.length(); int m=s.length();
    
        List<Integer>ans=new ArrayList<>();
        if(n>m) return ans;

        int[]freq1=new int[26];
        int[]freq2=new int[26];
        for(int i=0;i<n;i++){
            freq1[p.charAt(i)-'a']++;
            freq2[s.charAt(i)-'a']++;
        }
        if(matches(freq1,freq2)) ans.add(0); //first index
        for(int i=n;i<m;i++){
            freq2[s.charAt(i)-'a']++;
            freq2[s.charAt(i-n)-'a']--;
            if(matches(freq1,freq2))  ans.add(i-n+1); //ends at i but starts at i-n+1

        }
      return ans;
    }
    private boolean matches(int []a, int []b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}