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
    public boolean isValidBST(TreeNode root) {
       if(root == null)return true;
        
       return DFS(null, root, null); 
    }
    
    public boolean DFS(Integer min, TreeNode root, Integer max){
        if(root == null)return true;
        if((max != null && max <= root.val) || (min != null && min >= root.val))return false;
        
        return(DFS(min, root.left, root.val) && DFS(root.val, root.right, max));
    }
}