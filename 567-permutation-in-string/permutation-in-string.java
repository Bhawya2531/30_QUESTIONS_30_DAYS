class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length(); int m=s2.length();
        if(n>m) return false;
        HashMap<Character,Integer>map1=new HashMap<>();
        HashMap<Character,Integer>map2=new HashMap<>();
        for(char c:s1.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for(int i=0;i<n;i++){
            char c=s2.charAt(i);
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        if(map1.equals(map2)) return true;

        //slide the window 
        for(int i=n;i<m;i++){
            char add=s2.charAt(i);
            char remove=s2.charAt(i-n);
        //add the right
            map2.put(add,map2.getOrDefault(add,0)+1);
        //remove left character
            map2.put(remove,map2.get(remove)-1);
            if(map2.get(remove)==0){
                map2.remove(remove);
            }
            if(map1.equals(map2)) return true;
        }
        return false;
    }
}