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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode c= q.poll();
            
            TreeNode temp;
            temp= c.right;
            c.right= c.left;
            c.left= temp;
            if(c.left!=null)q.add(c.left);
            if(c.right!=null)q.add(c.right);
        }
        return root;
    }
}
