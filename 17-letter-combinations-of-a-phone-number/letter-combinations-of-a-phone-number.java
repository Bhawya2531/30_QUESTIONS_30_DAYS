class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>ans =new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        String[]mapping={
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        backtrack(0,digits,"",mapping,ans);
        return ans;
    }
    private void backtrack(int index, String digits, String current, String[]mapping,
                            List<String>ans){
                                if(index==digits.length()){
                                    ans.add(current);
                                    return;
                                }
                                int digit=digits.charAt(index)-'0';
                                String letters=mapping[digit];
                                for(char ch:letters.toCharArray()){
                                    backtrack(index+1,digits,current+ch,mapping,ans);
                                }
                            }
}

                              