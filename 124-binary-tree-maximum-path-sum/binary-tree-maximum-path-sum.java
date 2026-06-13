/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left; 
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxsum;
    public int maxPathSum(TreeNode root) {
        maxsum=Integer.MIN_VALUE;
        solve(root);
        return maxsum;
    }
    private int solve(TreeNode root){
        if(root==null) return 0;
        int l=Math.max(0,solve(root.left));
        int r=Math.max(0,solve(root.right));
        int neeche_mil_gya=l+r+root.val; //1
        int koi_ek_accha=Math.max(l,r)+root.val; //2
        int only_root_accha=root.val;    //3
        maxsum=Math.max(Math.max(maxsum,neeche_mil_gya),Math.max(koi_ek_accha,only_root_accha));
        return Math.max(koi_ek_accha,only_root_accha);
    }
}        
    