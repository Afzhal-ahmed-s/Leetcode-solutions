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
    boolean balanced = true;
    
    public boolean isBalanced(TreeNode root) {
        
        DFS(root);
        return balanced;
    }
    
    public int DFS(TreeNode root){
        
        if(root == null)return 0;
        
        int left = DFS(root.left);
        int right = DFS(root.right);
        
        if(Math.abs(left - right) > 1)balanced = false;
        
        return 1 + Math.max(left, right);
    }
}