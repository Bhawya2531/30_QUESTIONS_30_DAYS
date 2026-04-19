class Solution {
    static class Node{
        Node[]children=new Node[26]; //each node represents a char, children[26] links to next char 
        boolean eow=false;//marks end of valid word
    }
    Node root=new Node();//starting point of trie. every word starts from root
    //insert word into trie
    public void insert(String word){// insert function of trie, we will insert char by char of word
        Node curr=root;   //start inserting from root 
        for(char c:word.toCharArray()){     //go char by char
            int idx=c-'a';                 //a-'0',b-'1'
            if(curr.children[idx]==null){ // if path doesnt exist ->create new node
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx]; //move forward in Trie

        }
        curr.eow=true; //mark end of word
    }
    public boolean wordBreak(String s, List<String> wordDict) {//main function, entry point 
        //build trie
        for(String word:wordDict){   //build trie using dictionary
            insert(word);
        }
        Boolean[]dp=new Boolean[s.length()];
        return helper(s,0,dp);  //start recursion from index 0
    }
    private boolean helper(String s, int start, Boolean[]dp){
        if(start==s.length()) return true;
        if(dp[start]!=null) return dp[start];
        Node curr=root;
        for(int i=start;i<s.length();i++){
            int idx=s.charAt(i)-'a';     //get index of current char
            if(curr.children[idx]==null) break; //no word exists with this prefix-> stop early
            curr=curr.children[idx];  //move in trie 
            if(curr.eow){
                if(helper(s,i+1,dp)){
                    return dp[start]=true;
                }
            }
        }
        return dp[start]=false;
    }
}