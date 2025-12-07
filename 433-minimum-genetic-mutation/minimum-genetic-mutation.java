class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankSet = new HashSet<>();
        for(String b: bank) bankSet.add(b);

        if(!bankSet.contains(endGene)) return -1;

        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(startGene);
        visited.add(startGene);

        char[] genes = {'A','C','G','T'};
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String curr = queue.poll();
                if(curr.equals(endGene)) return level;

                for(int i = 0; i < curr.length(); i++){
                    for(char ch : genes){
                        if(curr.charAt(i) == ch) continue;

                        StringBuilder sb = new StringBuilder(curr);
                        sb.setCharAt(i, ch);
                        String next = sb.toString();

                        if(bankSet.contains(next) && !visited.contains(next)){
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}


        