class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>result=new ArrayList<>();
        StringBuilder curr=new StringBuilder();
        solve(curr,n,result);
        return result;
    }
        private void solve(StringBuilder curr, int n, List<String>result){
            if(curr.length()==2*n){
                if(valid(curr.toString())){
                    result.add(curr.toString());
                }
                return;
            }
            curr.append("(");
            solve(curr,n,result);
            curr.deleteCharAt(curr.length()-1);
            curr.append(")");
            solve(curr,n,result);
            curr.deleteCharAt(curr.length()-1);
        }
       private boolean valid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(')
                count++;
            else
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }
}