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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer>level=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(i==size-1){     // i is the last nod eof the level cuz this process nodes level by level 
                    result.add(node.val);
                }
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                }
            }
            return result;
    }
}
