class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String>bankSet=new HashSet<>();
        for(String b:bank) bankSet.add(b);
        if(!bankSet.contains(endGene)) return -1;
        HashSet<String>visited=new HashSet<>();
        Queue<String>q=new LinkedList<>();
        q.offer(startGene);
        visited.add(startGene);
        char[]genes={'A','G','C','T'};
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
        for(int i=0;i<size;i++){
            String curr=q.poll();
        if(curr.equals(endGene)) return level;
        for(int j=0;j<curr.length();j++){
            for(char ch:genes){
                if(curr.charAt(j)==ch) continue;
        StringBuilder sb=new StringBuilder(curr);
        sb.setCharAt(j,ch);
        String next=sb.toString();

        if(bankSet.contains(next) && !visited.contains(next)){
            visited.add(next);
            q.offer(next);
           }
       }
   }
}
level++;
}
return -1;
    }
}





        