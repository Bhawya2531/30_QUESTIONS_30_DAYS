class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>set=new HashSet<>();
        HashSet<String>visited=new HashSet<>();
        for(String word:wordList) set.add(word);
        if(!set.contains(endWord)) return 0;

        Queue<String>q=new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);

        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
            String curr=q.poll();
            if(curr.equals(endWord)) return level;
            char[]arr=curr.toCharArray();
            for(int i=0;i<arr.length;i++){
                char original=arr[i];
            for(char ch='a';ch<='z';ch++){
                arr[i]=ch;
                String next =new String(arr);
                if(set.contains(next)&&!visited.contains(next)){
                    q.offer(next);
                    visited.add(next);
                }
            }
            arr[i]=original;
            }
            }
            level++;
        }
        return 0;
    }
}

           