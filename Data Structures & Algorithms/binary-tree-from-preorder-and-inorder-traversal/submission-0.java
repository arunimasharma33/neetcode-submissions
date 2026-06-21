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
    int rootIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap <Integer, Integer> map= new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, map, 0, preorder.length);
    }
    public TreeNode helper(int[] preorder, HashMap<Integer,Integer> map, int start, int end){
        if(rootIndex>=preorder.length || start>=end) return null;
        int rootVal= preorder[rootIndex];
        
        TreeNode root= new TreeNode(rootVal);
        rootIndex++;
        int i=map.get(rootVal);
        root.left= helper(preorder, map, start, i);//upto i-1
        root.right= helper(preorder, map, i+1, end);
        return root;
    }
}
