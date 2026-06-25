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
    boolean valid=true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        if(!valid) return false;
        return true;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int leftH=dfs(root.left);
        int rightH=dfs(root.right);
        if(Math.abs(leftH-rightH)>1) {valid=false;}
        return Math.max(leftH, rightH)+1;
    }
}
