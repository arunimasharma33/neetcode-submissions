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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) return true;
        if(root==null) return false;
        if(subRoot==null) return true;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode c= q.poll();
            if(c.val==subRoot.val){
                if(isSame(c, subRoot)) return true;
            }
            if(c.left!=null) q.add(c.left);
            if(c.right!=null) q.add(c.right);
        }
        return false;
    }
    public boolean isSame(TreeNode c, TreeNode subRoot){
        if(c==null && subRoot==null) return true;
        if(c==null || subRoot==null) return false;
        if(c.val!=subRoot.val) return false;

        return isSame(c.left, subRoot.left) && isSame(c.right, subRoot.right);
    }
}
